package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.AccessTypeDao;
import com.company.entities.AccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component("jdbcAccessTypeDao")
public class JdbcAccessTypeDao implements AccessTypeDao {
    // Constant
    private static String ID = "id";
    private static String TYPE_NAME = "type_name";

    // Queries
    private static String SELECT_BY_ID = "SELECT * FROM \"ProjectManagement\".access_type WHERE id = :id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public AccessType getAccessTypeById(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, id);

        return jdbcTemplate.queryForObject(SELECT_BY_ID, params, new AccessTypeRowMapper());
    }

    private static final class AccessTypeRowMapper implements RowMapper<AccessType> {

        @Override
        public AccessType mapRow(ResultSet rs, int rowNum) throws SQLException {
            AccessType accessType = new AccessType();

            accessType.setId(rs.getLong(ID));
            accessType.setTypeName(rs.getString(TYPE_NAME));

            return accessType;
        }
    }
}
