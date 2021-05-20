package org.system.control.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Key extends AbstractEntity{
    @NotNull
    @OneToOne(targetEntity = User.class)
    private User user;

    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", owner is username='" + user.getName() + '\'' +
                '}';
    }
}
