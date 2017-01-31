package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.MemberDao;
import com.company.entities.AccessType;
import com.company.entities.Member;
import com.company.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("jdbcMemberDao")
public class JdbcMemberDao implements MemberDao {
    // Constant
    private static final String MEMBER = "member";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String ACCESS_TYPE = "access_type";
    private static final String ACCESS_TYPE_NAME = "access_name";
    private static final String POSITION = "position";
    private static final String POSITION_POS_NAME = "pos_name";
    private static final String PASSWORD = "password";
    private static final String TASK_ID = "task_id";
    private static final String EMPLOYEE = "task_id";

    // Queries
    private static final String INSERT = "INSERT INTO \"ProjectManagement\".member (name, surname, email, access_type, position, password)" +
            "VALUES (:name, :surname, :email, :access_type, :position, :password)";
    private static final String DELETE = "DELETE FROM \"ProjectManagement\".member WHERE id = :id";
    private static final String UPDATE = "UPDATE \"ProjectManagement\".member SET name = :name, surname = :surname, " +
            "email = :email, access_type = :type, position = :position, password = :password" +
            "WHERE id = :id";
    private static final String SELECT_BY_ID = "SELECT * FROM \"ProjectManagement\".member m JOIN \"ProjectManagement\".position p ON m.position = p.id " +
            "JOIN \"ProjectManagement\".access_type at ON m.access_type = at.id " +
            "WHERE m.id = :id";
    private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT * FROM \"ProjectManagement\".member m JOIN \"ProjectManagement\".access_type a ON m.access_type = a.id " +
            "LEFT JOIN \"ProjectManagement\".position p ON m.position = p.id " +
            "WHERE email = :email AND password = :password";
    private static final String SELECT_ALL_MEMBERS = "SELECT * FROM \"ProjectManagement\".member m JOIN \"ProjectManagement\".access_type a ON m.access_type = a.id " +
            "LEFT JOIN \"ProjectManagement\".position p ON m.position = p.id";
    private static final String SELECT_BY_POSITION = "SELECT * FROM \"ProjectManagement\".member WHERE position = :position";
    private static final String SELECT_EMPLOYEE_BY_TASK = "SELECT * FROM \"ProjectManagement\".task_executor tex JOIN " +
            "\"ProjectManagement\".member m ON tex.employee_id = m.id JOIN \"ProjectManagement\".position p ON m.position = p.id JOIN " +
            "\"ProjectManagement\".access_type at ON m.access_type = at.id " +
            "WHERE task_id = :task_id";
    private static final String SELECT_PROJECT_MANAGER = "SELECT * FROM \"ProjectManagement\".member m " +
            "JOIN \"ProjectManagement\".position p ON m.position = p.id " +
            "JOIN \"ProjectManagement\".access_type at ON m.access_type = at.id " +
            "WHERE p.id = 1";
    private static final String SELECT_AVAILABLE_EMPLOYEE = "SELECT * FROM \"ProjectManagement\".member m JOIN \"ProjectManagement\".access_type at ON m.access_type = at.id " +
            "JOIN \"ProjectManagement\".position p ON m.position = p.id\n" +
            "WHERE m.access_type = 2";
    private static final String SELECT_CUSTOMER_LIST = "SELECT * FROM \"ProjectManagement\".member m JOIN \"ProjectManagement\".access_type at ON m.access_type = at.id " +
            "JOIN \"ProjectManagement\".position p ON m.position = p.id\n" +
            "WHERE m.access_type = 3";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Integer insert(Member member) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(NAME, member.getName());
        params.addValue(SURNAME, member.getSurname());
        params.addValue(EMAIL, member.getEmail());
        params.addValue(POSITION, member.getPosition().getId());
        params.addValue(ACCESS_TYPE, member.getAccessType().getId());
        params.addValue(PASSWORD, member.getPassword());

        return jdbcTemplate.update(INSERT, params);
    }

    @Override
    public Integer delete(Member member) {
        return 0;
    }

    @Override
    public Integer update(Member member) {

        return 0;
    }

    @Override
    public Member getMemberById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, id);
        return jdbcTemplate.queryForObject(SELECT_BY_ID, params, new MemberRowMapper());
    }

    @Override
    public Member getMemberByEmailPassword(String email, String password) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(EMAIL, email);
        params.addValue(PASSWORD, password);

        try {
            return jdbcTemplate.queryForObject(SELECT_BY_EMAIL_PASSWORD, params, new MemberRowMapper());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<Member> getAllMembers() {
        return jdbcTemplate.query(SELECT_ALL_MEMBERS, new MemberRowMapper());
    }

    @Override
    public List<Member> getMemberByPosition(Position position) {
        return null;
    }

    @Override
    public List<Member> getEmployeeListByTask(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(TASK_ID, id);

        return jdbcTemplate.query(SELECT_EMPLOYEE_BY_TASK, params, new JdbcMemberDao.MemberRowMapper());

    }

    @Override
    public List<Member> getProjectManagerList() {
        return jdbcTemplate.query(SELECT_PROJECT_MANAGER, new MemberRowMapper());
    }

    @Override
    public List<Member> getAvailableEmployeeList() {
        return jdbcTemplate.query(SELECT_AVAILABLE_EMPLOYEE, new MemberRowMapper());
    }

    @Override
    public List<Member> getCustomerList() {
        return jdbcTemplate.query(SELECT_CUSTOMER_LIST, new MemberRowMapper());
    }

    private static final class MemberRowMapper implements RowMapper<Member>{

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();

            member.setId(rs.getLong(ID));
            member.setName(rs.getString(NAME));
            member.setSurname(rs.getString(SURNAME));
            member.setEmail(rs.getString(EMAIL));
            member.setPosition(new Position(rs.getLong(POSITION), rs.getString(POSITION_POS_NAME)));
            member.setAccessType(new AccessType(rs.getLong(ACCESS_TYPE), rs.getString(ACCESS_TYPE_NAME)));
            member.setPassword(rs.getString(PASSWORD));
            return member;
        }
    }
}
