package org.loversAPP.service.Impl;

import org.loversAPP.dao.DigHistoryMapper;
import org.loversAPP.dao.ItemTreasureMapper;
import org.loversAPP.dao.TreasureMapper;
import org.loversAPP.model.DigHistory;
import org.loversAPP.model.Treasure;
import org.loversAPP.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service
public class TreasureServiceImpl implements TreasureService {
    @Autowired
    private TreasureMapper treasureMapper;
    @Autowired
    private DigHistoryMapper digHistoryMapper;
    @Autowired
    private ItemTreasureMapper itemTreasureMapper;
    public Treasure getTreasureByID(int id) {
        return treasureMapper.getTreasureByID(id);
    }

    public int insertTreasure(Treasure treasure) {
        return treasureMapper.insertSelective(treasure);
    }

    public List<Treasure> getAllTreasures() {
        return treasureMapper.getAllTreasures();
    }

    public int insertDigHistory(DigHistory digHistory) {
        return digHistoryMapper.insertSelective(digHistory);
    }

    public int deleteTreasureByID(int id) {
        return treasureMapper.deleteTreasureByID(id);
    }

    public int insertBathch(List<Treasure> treasures) {
        return treasureMapper.insertBathch(treasures);
    }

    public int getItemIDbyTreasureCode(int treasureCode) {
        return itemTreasureMapper.getItemIDbyTreasureCode(treasureCode);
    }
}
