package org.loversAPP.service;

import org.loversAPP.model.DigHistory;
import org.loversAPP.model.Treasure;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface TreasureService {

    public Treasure getTreasureByID(int id);

    public int insertTreasure(Treasure treasure);


    public List<Treasure> getAllTreasures();

    public int insertDigHistory(DigHistory digHistory);

    public int deleteTreasureByID(int id);

    public int insertBathch(List<Treasure> treasures);

    public int getItemIDbyTreasureCode(int treasureCode);
}
