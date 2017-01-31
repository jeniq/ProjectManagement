package com.company.dao.jdbc.postgresql;

import com.company.dao.interfaces.PositionDao;
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

@Component("jdbcPositionDao")
public class JdbcPositionDao implements PositionDao {
    // Constants
    private static final String ID = "id";
    private static final String POS_NAME = "pos_name";

    // Queries
    private static final String INSERT = "INSERT INTO \"ProjectManagement\".position VALUES (:id, :name)";
    private static final String DELETE = "DELETE FROM \"ProjectManagement\".position WHERE id = :id";
    private static final String UPDATE = "UPDATE position SET \"ProjectManagement\".position = :position WHERE id = :id";
    private static final String SELECT_BY_ID = "SELECT * FROM \"ProjectManagement\".position WHERE id = :id";
    private static final String SELECT_ALL = "SELECT * FROM \"ProjectManagement\".position";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Integer insert(Position position) {
        return 0;
    }

    @Override
    public Integer delete(Position position) {
        return 0;
    }

    @Override
    public Integer update(Position position) {
        return 0;
    }

    @Override
    public Position getPositionById(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(ID, id);
        return jdbcTemplate.queryForObject(SELECT_BY_ID, params, new PositionRowMapper());
    }

    @Override
    public List<Position> getPositionList() {
        return jdbcTemplate.query(SELECT_ALL, new PositionRowMapper());
    }

    private static final class PositionRowMapper implements RowMapper<Position> {

        @Override
        public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
            Position position = new Position();

            position.setId(rs.getLong(ID));
            position.setPosName(rs.getString(POS_NAME));

            return position;
        }
    }
}
