package com.company.services.interfaces;

import com.company.entities.Sprint;

import java.util.List;

public interface SearchSprint {
    Sprint getSprintById(long id);

    // Search sprints for project with 'id'
    List<Sprint> getSprintList(long id);
}
