package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.TaskDao;
import com.company.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("jdbcTaskDao")
public class JdbcTaskDao implements TaskDao {
    // Constant
    private static String TASK = "task";
    private static String ID = "id";
    private static String SPRINT = "sprint";
    private static String TASK_NAME = "title";
    private static String DESCRIPTION = "description";
    private static String STATUS = "is_done";
    private static String START_DATE = "start_dt";
    private static String ESTIMATE_TIME = "estimate_tm";
    private static String END_DATE = "end_dt";
    private static String WEEK = "week_no";

    // Queries
    private static String SELECT_TASK_BY_SPRINT = "SELECT * FROM \"ProjectManagement\".task WHERE sprint = :sprint";
    private static String SELECT_HOURS = "SELECT COUNT(estimate.tm) FROM \"ProjectManagement\".task t " +
            "JOIN task_executor tex ON t.id = tex.task_id " +
            "HAVING employee_id = :id AND week_no = :week";

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

        return jdbcTemplate.query(SELECT_TASK_BY_SPRINT, params, new JdbcTaskDao.TaskRowMapper());
    }

    @Override
    public int getEmployeeLoadHoursById(long id, int week) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(ID, id);

        Number number =  jdbcTemplate.queryForObject(SELECT_HOURS, params, Integer.class);

        return (number != null ? number.intValue() : 0);
    }

    private static final class TaskRowMapper implements RowMapper<Task> {

        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();

            task.setId(rs.getLong(ID));
            task.setSprint(rs.getLong(SPRINT));
            task.setTitle(rs.getString(TASK_NAME));
            task.setDescription(rs.getString(DESCRIPTION));
            task.setIsDone(rs.getBoolean(STATUS));
            task.setStartDate(rs.getDate(START_DATE));
            task.setEstimateTime(rs.getInt(ESTIMATE_TIME));
            task.setEndDate(rs.getDate(END_DATE));
            task.setWeekNo(rs.getInt(WEEK));

            return task;
        }
    }
}
