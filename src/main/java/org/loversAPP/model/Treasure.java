package org.loversAPP.model;

public class Treasure extends TreasureKey {
    private String treasurename;

    private Integer treasurevalue;

    public String getTreasurename() {
        return treasurename;
    }

    public void setTreasurename(String treasurename) {
        this.treasurename = treasurename == null ? null : treasurename.trim();
    }

    public Integer getTreasurevalue() {
        return treasurevalue;
    }

    public void setTreasurevalue(Integer treasurevalue) {
        this.treasurevalue = treasurevalue;
    }
}