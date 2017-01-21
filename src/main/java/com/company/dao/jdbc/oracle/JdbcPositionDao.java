package com.company.dao.jdbc.oracle;

import com.company.dao.interfaces.PositionDao;
import com.company.entities.Position;

public class JdbcPositionDao implements PositionDao {
    // Queries
    private static String INSERT = "INSERT INTO position VALUES (:id, :name)";
    private static String DELETE = "DELETE FROM position WHERE id = :id";
    private static String UPDATE = "UPDATE position SET position = :position WHERE id = :id";
    private static String SELECT_BY_ID = "SELECT * FROM position WHERE id = :id";

    @Override
    public int insert(Position position) {
        return 0;
    }

    @Override
    public int delete(Position position) {
        return 0;
    }

    @Override
    public int update(Position position) {
        return 0;
    }

    @Override
    public Position getPositionById(int id) {
        return null;
    }
}
