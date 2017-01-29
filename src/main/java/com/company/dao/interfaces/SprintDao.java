package com.company.dao.interfaces;

import com.company.entities.Sprint;

import java.util.List;

public interface SprintDao extends DmlMethod<Sprint>{
    Sprint getSprintById(long id);
    List<Sprint> getSprintListByProjectId(long id);
    List<Sprint> getSprintListByMemberId(long id);
}
