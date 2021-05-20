package org.system.control.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.system.control.dto.entity.Room;
import org.system.control.dto.entity.User;
import org.system.control.dto.entity.Visitor;
import org.system.control.dto.repository.VisitorRepository;
import org.system.control.exception.ApiException;
import org.system.control.exception.ErrorCode;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class VisitorService {
    private final VisitorRepository visitorRepository;

    @Transactional
    public void save(Room room, User user) {
        if (room == null || user == null) {
            String message = "Wrong data for save";
            log.error(message);
            throw new ApiException(message, ErrorCode.error);
        }
        Visitor visitor = new Visitor(room, user);
        visitorRepository.save(visitor);
    }

    @Transactional
    public void delete(Long userId) {
        Visitor visitor = findVisitorByUserId(userId);
        visitorRepository.delete(visitor);
    }

    public Visitor findVisitorByUserId(Long userId) {
        return visitorRepository.findByUsersInsideId(userId);
    }

    public boolean isUserInsideRoom(User user) {
        List<Visitor> visitors = visitorRepository.findAllByUsersInsideId(user.getId());
        return visitors.size() > 0;
    }
}
