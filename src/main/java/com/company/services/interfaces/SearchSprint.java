package com.company.services.interfaces;

import com.company.entities.Sprint;

import java.util.List;

public interface SearchSprint {
    Sprint getSprintById(Long id);

    // Search sprint(s) for project with 'id'
    List<Sprint> getSprintList(Long id);

    // Search sprint(s) for member with 'id'
    List<Sprint> getSprintListByMember(Long id);

    Long getSprintNewId();
}
