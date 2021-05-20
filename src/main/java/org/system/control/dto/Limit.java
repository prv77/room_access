package org.system.control.dto;

import lombok.Getter;

@Getter
public class Limit {
    private final int roomLimit;
    private final int userLimit;

    public Limit(int roomLimit, int userLimit) {
        this.roomLimit = roomLimit;
        this.userLimit = userLimit;
    }
}
