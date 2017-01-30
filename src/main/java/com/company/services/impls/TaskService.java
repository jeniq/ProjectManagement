package com.company.services.impls;

import com.company.dao.interfaces.TaskDao;
import com.company.entities.Task;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.SearchTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements SearchTask, AlterEntity<Task> {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public List<Task> getTaskByEmpId(Long id) {
        return taskDao.getTaskListByEmployeeId(id);
    }

    @Override
    public List<Task> getTaskListBySprint(Long id) {
        return taskDao.getTaskListBySprintId(id);
    }

    @Override
    public boolean add(Task task) {
        int insertResult = taskDao.insert(task);

        return insertResult < 1 ? false : true;
    }

    @Override
    public Integer remove(Task task) {
        return null;
    }

    @Override
    public boolean edit(Task task) {
        return false;
    }
}
