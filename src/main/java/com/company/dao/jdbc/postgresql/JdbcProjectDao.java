package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.ProjectDao;
import com.company.entities.Project;
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

@Component("jdbcProjectDao")
public class JdbcProjectDao implements ProjectDao {

    // Constant
    private static String PROJECT = "project";
    private static String ID = "id";
    private static String TITLE = "title";
    private static String START_DATE = "start_dt";
    private static String END_DATE = "end_dt";

    // Queries
    private static String INSERT  = "";
    private static String DELETE  = "DELETE FROM \"ProjectManagement\".project WHERE id = :id";
    private static String UPDATE  = "";
    private static String SELECT_BY_ID  = "SELECT * FROM \"ProjectManagement\".project WHERE id = :id";
    private static String SELECT_BY_USER_ID  = "SELECT project_id FROM \"ProjectManagement\".project_customer WHERE customer_id = :id " +
                    "UNION SELECT project_id FROM \"ProjectManagement\".project_manager WHERE employee_id = :id " +
                    "UNION SELECT p.id FROM \"ProjectManagement\".task_executor tex " +
                    "JOIN \"ProjectManagement\".task t ON tex.task_id  = t.id " +
                    "JOIN \"ProjectManagement\".sprint s ON t.sprint = s.id " +
                    "JOIN \"ProjectManagement\".project p ON s.project = p.id " +
                    "WHERE employee_id = :id";
    private static String SELECT_ALL  = "SELECT * FROM \"ProjectManagement\".project";

    private SimpleJdbcInsert insertMember;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertMember = new SimpleJdbcInsert(dataSource).withTableName(PROJECT).usingColumns(
                TITLE, START_DATE, END_DATE
        );
    }

    @Override
    public int insert(Project project) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(TITLE, project.getTitle());
        params.addValue(START_DATE, project.getStartDate());
        params.addValue(END_DATE, project.getEndDate());

        return insertMember.execute(params);
    }

    @Override
    public int delete(Project project) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, project.getId());
        return jdbcTemplate.update(DELETE, params);
    }

    @Override
    public int update(Project project) {
        return 0;
    }

    @Override
    public Project getProjectById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, id);
        return jdbcTemplate.queryForObject(SELECT_BY_ID, params, new ProjectRowMapper());
    }

    @Override
    public List<Project> getProjectList() {
        return jdbcTemplate.query(SELECT_ALL, new ProjectRowMapper());
    }

    @Override
    public List<Project> getProjectList(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(ID, id);
        return jdbcTemplate.query(SELECT_BY_USER_ID, params, new ProjectRowMapper());
    }

    private static final class ProjectRowMapper implements RowMapper<Project> {

        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            Project project = new Project();

            project.setId(rs.getLong(ID));
            project.setTitle(rs.getString(TITLE));
            project.setStartDate(rs.getDate(START_DATE));
            project.setEndDate(rs.getDate(END_DATE));

            return project;
        }
    }
}
