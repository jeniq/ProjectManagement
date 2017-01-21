package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.MemberDao;
import com.company.entities.AccessType;
import com.company.entities.Member;
import com.company.entities.Position;
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

@Component("jdbcMemberDao")
public class JdbcMemberDao implements MemberDao {
    // Constants
    private static String MEMBER = "member";
    private static String ID = "id";
    private static String NAME = "name";
    private static String SURNAME = "surname";
    private static String EMAIL = "email";
    private static String ACCESS_TYPE = "access_type";
    private static String ACCESS_TYPE_NAME = "typename";
    private static String POSITION = "position";
    private static String POSITION_POS_NAME = "posname";
    private static String PASSWORD = "password";

    // Queries
    private static String DELETE = "DELETE FROM member WHERE id = :id";
    private static String UPDATE = "UPDATE member SET name = :name, surname = :surname, " +
            "email = :email, access_type = :type, position = :position, password = :password" +
            "WHERE id = :id";
    private static String SELECT_BY_ID = "SELECT * FROM member WHERE id = :id";
    private static String SELECT_BY_EMAIL_PASSWORD = "SELECT * FROM member m JOIN access_type a ON m.access_type = a.id " +
            "LEFT JOIN position p ON m.position = p.id " +
            "WHERE email = :email AND password = :password";
    private static String SELECT_ALL_MEMBERS = "SELECT * FROM member m JOIN access_type a ON m.access_type = a.id " +
            "LEFT JOIN position p ON m.position = p.id";
    private static String SELECT_BY_POSITION = "SELECT * FROM member WHERE position = :position";

    private SimpleJdbcInsert insertMember;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertMember = new SimpleJdbcInsert(dataSource).withTableName(MEMBER).usingColumns(
                NAME,
                SURNAME,
                EMAIL,
                ACCESS_TYPE,
                POSITION,
                PASSWORD
        );
    }

    @Override
    public int insert(Member member) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue(NAME, member.getName());
        params.addValue(SURNAME, member.getSurname());
        params.addValue(EMAIL, member.getEmail());
        params.addValue(ACCESS_TYPE, member.getAccessType());
        params.addValue(POSITION, member.getPosition());
        params.addValue(PASSWORD, member.getPassword());

        return insertMember.execute(params);
    }

    @Override
    public int delete(Member member) {

        return 0;
    }

    @Override
    public int update(Member member) {

        return 0;
    }

    @Override
    public Member getMemberById(int id) {
        return null;
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
