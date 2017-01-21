package com.company.entities;

import org.springframework.stereotype.Component;

@Component
public class AccessType {
    private Long id;
    private String typeName;

    public AccessType() {
    }


    public AccessType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public AccessType(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public Long getId() {
        return id;
    }
}