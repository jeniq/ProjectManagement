package com.company.services.impls;

import com.company.dao.interfaces.SprintDao;
import com.company.dao.interfaces.TaskDao;
import com.company.entities.Sprint;
import com.company.entities.Task;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.SearchSprint;
import com.company.services.interfaces.SprintInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService implements SearchSprint, AlterEntity<Sprint>, SprintInfo{

    @Autowired
    private SprintDao sprintDao;

    @Autowired
    private TaskDao taskDao;

    @Override
    public Sprint getSprintById(Long id) {
        return sprintDao.getSprintById(id);
    }

    @Override
    public List<Sprint> getSprintList(Long id) {
        return sprintDao.getSprintListByProjectId(id);
    }

    @Override
    public List<Sprint> getSprintListByMember(Long id) {
        return sprintDao.getSprintListByMemberId(id);
    }

    @Override
    public Long getSprintNewId() {
        return sprintDao.getSprintMaxId() + 1;
    }

    @Override
    public Integer add(Sprint sprint) {
        return sprintDao.insert(sprint);
    }

    @Override
    public Integer remove(Sprint sprint) {
        return null;
    }

    @Override
    public Integer edit(Sprint sprint) {
        return 0;
    }

    @Override
    public Integer getSprintProgress(Sprint sprint) {
        int doneTask = 0;
        List<Task> taskList = taskDao.getTaskListBySprintId(sprint.getId());

        for (Task t : taskList){
            if (t.getIsDone()){
                doneTask++;
            }
        }

        return taskList.size() == 0 ? 0 : doneTask/taskList.size()*100;
    }
}
