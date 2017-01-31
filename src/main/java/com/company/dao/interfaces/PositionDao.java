package com.company.dao.interfaces;

import com.company.entities.Position;

import java.util.List;

public interface PositionDao extends DmlMethod<Position> {
    Position getPositionById(Integer id);

    List<Position> getPositionList();
}
