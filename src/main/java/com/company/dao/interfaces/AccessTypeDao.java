package com.company.dao.interfaces;

import com.company.entities.AccessType;

import java.util.List;

public interface AccessTypeDao {
    AccessType getAccessTypeById(Integer id);

    List<AccessType> getAccessTypeList();
}
