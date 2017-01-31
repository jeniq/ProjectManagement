package com.company.services.interfaces;

import com.company.entities.Position;

import java.util.List;

public interface SearchPosition {
    List<Position> getPositionList();

    Position getById(Integer id);
}
