package com.company.services.interfaces;

import com.company.entities.Task;

import java.util.List;

public interface SearchTask {
    Task getTaskById(Long id);

    // Searches task for employee with 'id'
    List<Task> getTaskByEmpId(Long id);

    // Searches task(s) for sprint with 'id'
    List<Task> getTaskListBySprint(Long id);
}
