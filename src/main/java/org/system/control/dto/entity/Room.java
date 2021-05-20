package org.system.control.dto.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Room extends AbstractEntity {
    private String roomNumber;

    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", name='" + getRoomNumber() + '\'' +
                '}';
    }
}
