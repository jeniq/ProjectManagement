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
    public Sprint getSprintById(long id) {
        return null;
    }

    @Override
    public List<Sprint> getSprintList(long id) {
        return sprintDao.getSprintListByProjectId(id);
    }

    @Override
    public List<Sprint> getSprintListByMember(long id) {
        return sprintDao.getSprintListByMemberId(id);
    }

    @Override
    public Long getSprintNewId() {
        return sprintDao.getSprintMaxId() + 1;
    }

    @Override
    public boolean add(Sprint sprint) {
        int insertResult = sprintDao.insert(sprint);

        return insertResult < 1 ? false : true;
    }

    @Override
    public Integer remove(Sprint sprint) {
        return null;
    }

    @Override
    public boolean edit(Sprint sprint) {
        return false;
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
