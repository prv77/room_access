package org.system.control.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.system.control.dto.Limit;
import org.system.control.dto.entity.Key;
import org.system.control.dto.entity.Room;
import org.system.control.dto.entity.User;
import org.system.control.exception.ApiException;
import org.system.control.exception.ErrorCode;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccessService {
    private final RoomService roomService;
    private final KeyService keyService;
    private final UserService userService;
    private final VisitorService visitorService;
    private final Limit limit;

    public String process(String roomId, boolean entrance, String keyId) {

        if(limit.getRoomLimit() < Integer.parseInt(roomId) || limit.getUserLimit() < Integer.parseInt(keyId)
            || Integer.parseInt(roomId) == 0) {
            log.error("Deny access, action={}, wrong incoming data, limit's has been reached: room id={}, key id={}", getAction(entrance), roomId, keyId);
            throw new ApiException(ErrorCode.deny);
        }

        Room room = roomService.findRoomById(Long.parseLong(roomId));
        if (room == null) {
            log.error("Deny access, action={}, room id={} not valid", getAction(entrance), roomId);
            throw new ApiException(ErrorCode.deny);
        }

        Key key = keyService.findKeyById(Long.parseLong(keyId));
        if (key == null) {
            log.error("Deny access, action={}, key id={} not valid", getAction(entrance), keyId);
            throw new ApiException(ErrorCode.deny);
        }

        User user = userService.findUserById(key.getUser().getId());
        if (!user.isPersisted()) {
            log.error("Deny access, action={}, user={} have no this key={}",getAction(entrance), user, key);
            throw new ApiException(ErrorCode.deny);
        }

        if (!userService.isAccessGranted(room.getId(), user.getId())) {
            log.error("Deny access, action={}, user={} have no access this room={}", getAction(entrance), user, room);
            throw new ApiException(ErrorCode.deny);
        }

        if (visitorService.isUserInsideRoom(user) && entrance) {
            log.error("Deny access, action={}, user={} already in room={}", getAction(true),user, room);
            throw new ApiException(ErrorCode.deny);
        }

        if (!visitorService.isUserInsideRoom(user) && !entrance) {
            log.error("Deny access, action={}, user={} not registered in room={}", getAction(false), user, room);
            throw new ApiException(ErrorCode.deny);
        }

        if (entrance) {
            visitorService.save(room, user);
        } else {
            visitorService.delete(user.getId());
        }

        log.info("Allow access for user={}, room={}, action={}",user, room, getAction(entrance));
        return ErrorCode.allow.getStringValue();
    }

    private String getAction(boolean entrance) {
        return (entrance ? "in" : "out");
    }
}
