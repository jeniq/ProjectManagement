package com.company.dao.interfaces;

import com.company.entities.Project;

import java.util.List;

/**
 * This interface sets rules for actions with 'project' table in database.
 */
public interface ProjectDao extends DmlMethod<Project>{
    boolean create(Project project, Integer manager, Long customer);

    // Find project for user with id
    Project getProjectById(Long id);

    // Find all projects
    List<Project> getProjectList();

    // Find project(s) for user with 'id'
    List<Project> getProjectList(Long id);

}
