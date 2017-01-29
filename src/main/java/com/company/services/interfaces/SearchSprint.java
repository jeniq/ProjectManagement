package com.company.services.interfaces;

import com.company.entities.Sprint;

import java.util.List;

public interface SearchSprint {
    Sprint getSprintById(long id);

    // Search sprint(s) for project with 'id'
    List<Sprint> getSprintList(long id);

    // Search sprint(s) for member with 'id'
    List<Sprint> getSprintListByMember(long id);
}
