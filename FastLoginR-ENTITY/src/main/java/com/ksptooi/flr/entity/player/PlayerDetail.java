package com.ksptooi.flr.entity.player;

public class PlayerDetail {

    private Integer id;
    private Integer pid;
    private Double foodLevel;
    private Double healtLevel;
    private Double oxygenLevel;
    private Double exp;
    private Double level;

    @Override
    public String toString() {
        return "PlayerDetail{" +
                "id=" + id +
                ", pid=" + pid +
                ", foodLevel=" + foodLevel +
                ", healtLevel=" + healtLevel +
                ", oxygenLevel=" + oxygenLevel +
                ", exp=" + exp +
                ", level=" + level +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(Double foodLevel) {
        this.foodLevel = foodLevel;
    }

    public Double getHealtLevel() {
        return healtLevel;
    }

    public void setHealtLevel(Double healtLevel) {
        this.healtLevel = healtLevel;
    }

    public Double getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(Double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public Double getExp() {
        return exp;
    }

    public void setExp(Double exp) {
        this.exp = exp;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }
}
