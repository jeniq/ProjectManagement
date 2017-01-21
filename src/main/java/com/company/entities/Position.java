package com.company.entities;

import org.springframework.stereotype.Component;

@Component
public class Position {
    private Long id;
    private String posName;

    Position() {
    }

    public Position(Long id, String posName) {
        this.id = id;
        this.posName = posName;
    }

    public Position(Long id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

}
