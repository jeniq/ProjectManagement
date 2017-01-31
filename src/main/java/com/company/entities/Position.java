package com.company.entities;

import org.springframework.stereotype.Component;

@Component
public class Position {
    private Long id;
    private String posName;

    public Position() {
    }

    public Position(Long id, String posName) {
        this.id = id;
        this.posName = posName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
