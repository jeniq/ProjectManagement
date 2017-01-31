package com.company.services.impls;

import com.company.dao.interfaces.AccessTypeDao;
import com.company.entities.AccessType;
import com.company.services.interfaces.SearchAccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessTypeService implements SearchAccessType {
    @Autowired
    private AccessTypeDao accessTypeDao;

    @Override
    public AccessType getById(Integer id) {
        return accessTypeDao.getAccessTypeById(id);
    }

    @Override
    public List<AccessType> getAccessTypeList() {
        return accessTypeDao.getAccessTypeList();
    }
}
