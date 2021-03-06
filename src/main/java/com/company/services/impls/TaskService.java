package com.company.services.impls;

import com.company.dao.interfaces.TaskDao;
import com.company.entities.Member;
import com.company.entities.Task;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.EditTask;
import com.company.services.interfaces.SearchTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements SearchTask, AlterEntity<Task>, EditTask {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private SprintService sprintService;

    @Autowired
    private ProjectService projectService;

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTask(id);
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
    public Long getNewTaskId() {
        return taskDao.getTaskMaxId() + 1;
    }

    @Override
    public Integer add(Task task) {
        return taskDao.insert(task);
    }

    @Override
    public Integer remove(Task task) {
        return null;
    }

    @Override
    public Integer edit(Task task) {
        // update sprint progress
        sprintService.updateProgress(task.getSprint());

        // update project progress
        projectService.updateProgress(sprintService.getSprintById(task.getSprint()).getProjectId());
        return taskDao.update(task);
    }

    @Override
    public boolean create(Task task, Member executor) {
        if (!task.getStartDate().before(task.getEndDate())) { // check date order
            return false;
        }
        return taskDao.create(task, executor);
    }
}
