package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.ProjectConsumerDao;
import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public class JdbcProjectConsumerDao implements ProjectConsumerDao {
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
    public List<Member> getMemberByProjectId(int id) {
        return null;
    }

    @Override
    public List<Project> getProjectByMemberId(int id) {
        return null;
    }
}
