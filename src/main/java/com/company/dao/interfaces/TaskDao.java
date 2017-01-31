package com.company.dao.interfaces;

import com.company.entities.Member;
import com.company.entities.Task;

import java.util.List;

public interface TaskDao extends DmlMethod<Task> {
    boolean create(Task task, Member member);

    Task getTask(long id);

    // Get task list for sprint with 'id'
    List<Task> getTaskListBySprintId(Long id);

    //
    int getEmployeeLoadHoursById(Long id, Integer week);

    List<Task> getTaskListByEmployeeId(Long id);

    Long getTaskMaxId();

}
