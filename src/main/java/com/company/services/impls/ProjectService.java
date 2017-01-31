package com.company.services.impls;

import com.company.dao.interfaces.ProjectDao;
import com.company.entities.Member;
import com.company.entities.Project;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.EditProject;
import com.company.services.interfaces.SearchProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements SearchProject, AlterEntity<Project>, EditProject{

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Project getProjectById(Integer id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public List<Project> getProjectList(Member member) {
        if (member.getAccessType().getTypeName().equals("Administrator")){return projectDao.getProjectList();
        }

        return projectDao.getProjectList(member.getId());
    }

    @Override
    public Project details(Integer id) {
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
        return 0;
    }

    @Override
    public boolean create(Project project, int projectManagerId, Long customerId) {
        if (!project.getStartDate().before(project.getEndDate())){ // check date order
            return false;
        }
       return projectDao.create(project, projectManagerId, customerId);
    }
}
