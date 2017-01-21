package com.company.dao.interfaces;

import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public interface ProjectManagerDao extends DmlMethod<Integer>{
    List<Member> getProjectManagerByProjectId(int id);
    List<Project> getProjectByProjectManId(int id);
}
