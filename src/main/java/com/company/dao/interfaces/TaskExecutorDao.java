package com.company.dao.interfaces;

import com.company.entities.Member;
import com.company.entities.Task;

import java.util.List;

public interface TaskExecutorDao extends DmlMethod<Integer>{
    List<Member> getTaskByEmpId(int id);
    List<Task> getEmployeeByTaskId(int id);
}
