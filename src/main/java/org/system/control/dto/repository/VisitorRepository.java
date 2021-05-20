package org.system.control.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.control.dto.entity.Visitor;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findAllByUsersInsideId(Long usersInside_id);

    Visitor findByUsersInsideId(Long usersInside_id);
}
