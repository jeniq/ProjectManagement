package com.company.services.interfaces;

import com.company.entities.AccessType;

import java.util.List;

public interface SearchAccessType {
    AccessType getById(Integer id);
    List<AccessType> getAccessTypeList();

}
