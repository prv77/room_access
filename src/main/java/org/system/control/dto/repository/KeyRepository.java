package org.system.control.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.control.dto.entity.Key;

public interface KeyRepository extends JpaRepository<Key, Long> {
}
