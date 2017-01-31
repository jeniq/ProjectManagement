package com.company.services.interfaces;

import com.company.entities.Project;

public interface EditProject {
    boolean create(Project project, Integer projectManagerId, Long customerId);
    Integer updateProgress(Long id);
}
