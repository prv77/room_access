package org.system.control.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.control.dto.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
