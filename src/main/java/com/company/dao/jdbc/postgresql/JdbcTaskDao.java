package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.TaskDao;
import com.company.entities.Member;
import com.company.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("jdbcTaskDao")
public class JdbcTaskDao implements TaskDao {
    // Constant
    private static final String TASK = "task";
    private static final String ID = "id";
    private static final String SPRINT = "sprint";
    private static final String TASK_NAME = "title";
    private static final String DESCRIPTION = "description";
    private static final String STATUS = "is_done";
    private static final String START_DATE = "start_dt";
    private static final String ESTIMATE_TIME = "estimate_tm";
    private static final String END_DATE = "end_dt";
    private static final String WEEK = "week_no";
    private static final String EMPLOYEE_ID = "employee_id";
    private static final String TASK_ID = "task_id";

    // Queries
    private static final String INSERT = "INSERT INTO \"ProjectManagement\".task (sprint, title, is_done, start_dt, end_dt, estimate_tm) " +
            "VALUES (:sprint, :title, :is_done, :start_dt, :end_dt, :estimate_tm)";
    private static final String UPDATE = "UPDATE \"ProjectManagement\".task " +
            "SET sprint = :sprint, title = :title, is_done = :is_done, start_dt = :start_dt, end_dt = :end_dt, estimate_tm = :estimate_tm";
    private static final String INSERT_EXECUTOR = "INSERT INTO \"ProjectManagement\".task_executor VALUES (:employee_id, :task_id)";
    private static final String SELECT_TASK_BY_SPRINT = "SELECT * FROM \"ProjectManagement\".task WHERE sprint = :sprint";
    private static final String SELECT_HOURS = "SELECT COUNT(estimate.tm) FROM \"ProjectManagement\".task t " +
            "JOIN task_executor tex ON t.id = tex.task_id " +
            "HAVING employee_id = :id AND week_no = :week";
    private static final String SELECT_TASK_BY_EMPLOYEE = "SELECT * FROM \"ProjectManagement\".task_executor tex JOIN " +
            "\"ProjectManagement\".task t ON tex.task_id = t.id " +
            "WHERE employee_id = :employee_id";
    private static final String SELECT_MAX_ID = "SELECT last_value FROM \"ProjectManagement\".task_id_seq";

    private static final String SELECT_TASK = "SELECT * FROM \"ProjectManagement\".task WHERE id = :id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public Integer insert(Task task) {
        return 0;
    }

    @Override
    public Integer delete(Task task) {
        return 0;
    }

    @Override
    public Integer update(Task task) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(SPRINT, task.getSprint());
        params.addValue(TASK_NAME, task.getTitle());
        params.addValue(STATUS, task.getIsDone());
        params.addValue(START_DATE, task.getStartDate());
        params.addValue(END_DATE, task.getEndDate());
        params.addValue(ESTIMATE_TIME, task.getEstimateTime());
        params.addValue(WEEK, task.getWeekNo());

        return jdbcTemplate.update(UPDATE, params);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean create(Task task, Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(SPRINT, task.getSprint());
        params.addValue(TASK_NAME, task.getTitle());
        params.addValue(STATUS, task.getDone());
        params.addValue(START_DATE, task.getStartDate());
        params.addValue(END_DATE, task.getEndDate());
        params.addValue(ESTIMATE_TIME, task.getEstimateTime());

        jdbcTemplate.update(INSERT, params, keyHolder, new String[]{ID});

        params.addValue(EMPLOYEE_ID, member.getId());
        params.addValue(TASK_ID, keyHolder.getKey());

        jdbcTemplate.update(INSERT_EXECUTOR, params);

        return true;
    }

    @Override
    public Task getTask(long id) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(ID, id);

        return jdbcTemplate.queryForObject(SELECT_TASK, params, new JdbcTaskDao.TaskRowMapper());
    }

    @Override
    public List<Task> getTaskListBySprintId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(SPRINT, id);

        return jdbcTemplate.query(SELECT_TASK_BY_SPRINT, params, new JdbcTaskDao.TaskRowMapper());
    }

    @Override
    public int getEmployeeLoadHoursById(Long id, Integer week) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(ID, id);

        Number number = jdbcTemplate.queryForObject(SELECT_HOURS, params, Integer.class);

        return (number != null ? number.intValue() : 0);
    }

    @Override
    public List<Task> getTaskListByEmployeeId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(EMPLOYEE_ID, id);

        return jdbcTemplate.query(SELECT_TASK_BY_EMPLOYEE, params, new JdbcTaskDao.TaskRowMapper());

    }

    @Override
    public Long getTaskMaxId() {
        MapSqlParameterSource params = new MapSqlParameterSource();

        return jdbcTemplate.queryForObject(SELECT_MAX_ID, params, Integer.class).longValue();
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
