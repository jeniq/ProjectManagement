package com.company.services.impls;

import com.company.dao.interfaces.SprintDao;
import com.company.entities.Sprint;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.SearchSprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService implements SearchSprint, AlterEntity<Sprint>{

    @Autowired
    private SprintDao sprintDao;

    @Override
    public Sprint getSprintById(long id) {
        return null;
    }

    @Override
    public List<Sprint> getSprintList(long id) {
        return sprintDao.getSprintListByProjectId(id);
    }

    @Override
    public boolean add(Sprint sprint) {
        return false;
    }

    @Override
    public boolean remove(Sprint sprint) {
        return false;
    }

    @Override
    public boolean edit(Sprint sprint) {
        return false;
    }

}
