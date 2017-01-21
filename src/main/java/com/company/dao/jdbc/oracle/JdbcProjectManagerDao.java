package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.ProjectManagerDao;
import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public class JdbcProjectManagerDao implements ProjectManagerDao {
    @Override
    public int insert(Integer integer) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public int update(Integer integer) {
        return 0;
    }

    @Override
    public List<Member> getProjectManagerByProjectId(int id) {
        return null;
    }

    @Override
    public List<Project> getProjectByProjectManId(int id) {
        return null;
    }
}
