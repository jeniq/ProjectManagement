package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.SprintDao;
import com.company.entities.Sprint;
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

@Component("jdbcSprintDao")
public class JdbcSprintDao implements SprintDao {
    // Constant
    private static String SPRINT = "sprint";
    private static String ID = "id";
    private static String STATUS = "is_done";
    private static String PROJECT = "project";
    private static String PROJECT_ID = "project_id";

    // Queries
    private static String SELECT_SPRINT_BY_PROJECT = "SELECT * FROM \"ProjectManagement\".sprint WHERE project = :project_id";
    private static String SELECT_SPRINT_BY_MEMBER = "SELECT * FROM \"ProjectManagement\".sprint s " +
            "JOIN \"ProjectManagement\".task t ON s.id = t.sprint " +
            "JOIN \"ProjectManagement\".task_executor tex ON t.id = tex.task_id " +
            "WHERE employee_id = :id";

    private SimpleJdbcInsert insertSprint;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertSprint = new SimpleJdbcInsert(dataSource).withTableName(SPRINT).usingColumns(
                ID,
                STATUS,
                PROJECT
        );
    }


    @Override
    public Sprint getSprintById(long id) {
        return null;
    }

    @Override
    public List<Sprint> getSprintListByProjectId(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(PROJECT_ID, id);

        return jdbcTemplate.query(SELECT_SPRINT_BY_PROJECT, params, new JdbcSprintDao.SprintRowMapper());
    }

    @Override
    public List<Sprint> getSprintListByMemberId(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, id);

        return jdbcTemplate.query(SELECT_SPRINT_BY_MEMBER, params, new JdbcSprintDao.SprintRowMapper());
    }

    @Override
    public int insert(Sprint sprint) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(ID, sprint.getId());
        params.addValue(STATUS, sprint.getDone());
        params.addValue(PROJECT, sprint.getProjectId());

        return insertSprint.execute(params);

    }

    @Override
    public int delete(Sprint sprint) {
        return 0;
    }

    @Override
    public int update(Sprint sprint) {
        return 0;
    }

    private static final class SprintRowMapper implements RowMapper<Sprint> {

        @Override
        public Sprint mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sprint sprint = new Sprint();

            sprint.setId(rs.getLong(ID));
            sprint.setDone(rs.getBoolean(STATUS));
            sprint.setProjectId(rs.getLong(PROJECT));

            return sprint;
        }
    }
}
