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
    public boolean add(Project project) {
        return false;
    }

    @Override
    public Integer remove(Project project) {
        return projectDao.delete(project);
    }

    @Override
    public boolean edit(Project project) {
        return false;
    }


    @Override
    public boolean create(Project project, int projectManagerId) {
       return projectDao.create(project, projectManagerId);
    }
}
