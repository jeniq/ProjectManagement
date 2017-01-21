package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.TaskExecutorDao;
import com.company.entities.Member;
import com.company.entities.Task;

import java.util.List;

public class JdbcTaskExecutorDao implements TaskExecutorDao {
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
    public List<Member> getTaskByEmpId(int id) {
        return null;
    }

    @Override
    public List<Task> getEmployeeByTaskId(int id) {
        return null;
    }
}
