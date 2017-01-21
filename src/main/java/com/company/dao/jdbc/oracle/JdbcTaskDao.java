package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.TaskDao;
import com.company.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTaskDao implements TaskDao {
    // Constants
    private static String TASK = "task";
    private static String ID = "id";
    private static String SPRINT = "sprint";
    private static String TASK_NAME = "taskname";
    private static String DESCRIPTION = "description";
    private static String STATUS = "status";
    private static String START_DATE = "start_dt";
    private static String ESTIMATE_TIME = "estimate_tm";
    private static String END_DATE = "end_dt";

    // Queries
    private static String SELECT_TASK_BY_SPRINT = "SELECT * FROM task WHERE sprint = :sprint";

    private SimpleJdbcInsert insertTask;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertTask = new SimpleJdbcInsert(dataSource).withTableName(TASK).usingColumns(
                ID,
                SPRINT,
                TASK_NAME,
                DESCRIPTION,
                STATUS,
                START_DATE,
                ESTIMATE_TIME,
                END_DATE
        );

    }


    @Override
    public int insert(Task task) {
        return 0;
    }

    @Override
    public int delete(Task task) {
        return 0;
    }

    @Override
    public int update(Task task) {
        return 0;
    }

    @Override
    public Task getTask(long id) {
        return null;
    }

    @Override
    public List<Task> getTaskListBySprintId(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(SPRINT, id);

        return jdbcTemplate.query(SELECT_TASK_BY_SPRINT, new JdbcTaskDao.TaskRowMapper());
    }

    private static final class TaskRowMapper implements RowMapper<Task> {

        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();

            task.setSprint(rs.getLong(SPRINT));
            task.setTitle(rs.getString(TASK_NAME));
            task.setDescription(rs.getString(DESCRIPTION));
            task.setDone(rs.getBoolean(STATUS));
            task.setStartDate(rs.getDate(START_DATE));
            task.setEstimateTime(rs.getInt(ESTIMATE_TIME));
            task.setEndDate(rs.getDate(END_DATE));

            return task;
        }
    }
}
