package org.system.control.dto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Visitor extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room visitRoom;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User usersInside;

    public Visitor(Room visitRoom, User usersInside) {
        this.visitRoom = visitRoom;
        this.usersInside = usersInside;
    }
}
