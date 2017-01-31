package com.company.services.impls;

import com.company.dao.interfaces.ProjectDao;
import com.company.dao.interfaces.SprintDao;
import com.company.entities.Member;
import com.company.entities.Project;
import com.company.entities.Sprint;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.EditProject;
import com.company.services.interfaces.ProjectInfo;
import com.company.services.interfaces.SearchProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements SearchProject, AlterEntity<Project>, EditProject, ProjectInfo{

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private SprintDao sprintDao;

    @Override
    public Project getProjectById(Long id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public List<Project> getProjectList(Member member) {
        if (member.getAccessType().getTypeName().equals("Administrator")){return projectDao.getProjectList();
        }

        return projectDao.getProjectList(member.getId());
    }

    @Override
    public Project details(Long id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public Integer add(Project project) {
        return 0;
    }

    @Override
    public Integer remove(Project project) {
        return projectDao.delete(project);
    }

    @Override
    public Integer edit(Project project) {
        return projectDao.update(project);
    }

    @Override
    public boolean create(Project project, Integer projectManagerId, Long customerId) {
        if (!project.getStartDate().before(project.getEndDate())){ // check date order
            return false;
        }
       return projectDao.create(project, projectManagerId, customerId);
    }

    @Override
    public Integer updateProgress(Long id) {
        Project project = getProjectById(id);
        project.setProgress(getProjectProgress(project));

        return edit(project);
    }

    @Override
    public Integer getProjectProgress(Project project) {
        int sprintProgress = 0;
        List<Sprint> sprintList = sprintDao.getSprintListByProjectId(project.getId());

        for (Sprint s : sprintList){
            sprintProgress += s.getProgress();
        }

        return sprintList.size() > 0 ? sprintProgress / sprintList.size() : 0;
    }
}
