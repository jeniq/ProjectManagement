package com.company.services.interfaces;

import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public interface SearchProject {
    List<Project> getProjectList(Member member);
    Project details();
}
