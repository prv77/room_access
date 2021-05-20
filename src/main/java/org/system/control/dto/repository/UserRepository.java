package org.system.control.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.control.dto.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
