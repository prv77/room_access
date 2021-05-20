package org.system.control.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.system.control.dto.entity.Room;
import org.system.control.dto.repository.RoomRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

}
