package com.company.dao.interfaces;

import com.company.entities.Position;

public interface PositionDao extends DmlMethod<Position>{
    Position getPositionById(int id);
}
