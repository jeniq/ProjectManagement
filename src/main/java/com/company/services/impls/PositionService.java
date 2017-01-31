package com.company.services.impls;

import com.company.dao.interfaces.PositionDao;
import com.company.entities.Position;
import com.company.services.interfaces.SearchPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements SearchPosition {

    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> getPositionList() {
        return positionDao.getPositionList();
    }

    @Override
    public Position getById(Integer id) {
        return positionDao.getPositionById(id);
    }
}
