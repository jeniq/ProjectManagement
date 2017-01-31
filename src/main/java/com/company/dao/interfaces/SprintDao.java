package com.company.dao.interfaces;

import com.company.entities.Sprint;

import java.util.List;

public interface SprintDao extends DmlMethod<Sprint> {
    Sprint getSprintById(Long id);

    List<Sprint> getSprintListByProjectId(Long id);

    List<Sprint> getSprintListByMemberId(Long id);

    Long getSprintMaxId();

    Integer updateSprintProgress(Sprint sprint);
}
