package com.company.services.interfaces;

import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public interface SearchProject {
    Project getProjectById(Long id);

    List<Project> getProjectList(Member member);

    Project details(Long id);
}
