package com.company.services.impls;

import com.company.dao.interfaces.ProjectDao;
import com.company.entities.Member;
import com.company.entities.Project;
import com.company.services.interfaces.AlterEntity;
import com.company.services.interfaces.SearchProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements SearchProject, AlterEntity<Project>{

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getProjectList(Member member) {
        if (member.getAccessType().getTypeName().equals("Administrator")){return projectDao.getProjectList();
        }

        return projectDao.getProjectList(member.getId());
    }

    @Override
    public Project details() {
        return null;
    }

    @Override
    public boolean add(Project project) {
        int insertResult = projectDao.insert(project);

        if (insertResult < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Project project) {
        return false;
    }

    @Override
    public boolean edit(Project project) {
        return false;
    }
}
