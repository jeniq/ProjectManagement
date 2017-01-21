package com.company.dao.interfaces;

import com.company.entities.Task;

import java.util.List;

public interface TaskDao extends DmlMethod<Task>{
    Task getTask(long id);

    // Get task list for sprint with 'id'
    List<Task> getTaskListBySprintId(long id);
}
