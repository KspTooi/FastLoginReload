package com.ksptooi.flr.entity.player;

public class PlayerDetail {

    private Integer id;
    private Integer pid;
    private Integer foodLevel;
    private Double healthLevel;
    private Double oxygenLevel;
    private Float exp;
    private Integer level;
    private String email;

    @Override
    public String toString() {
        return "PlayerDetail{" +
                "id=" + id +
                ", pid=" + pid +
                ", foodLevel=" + foodLevel +
                ", healthLevel=" + healthLevel +
                ", oxygenLevel=" + oxygenLevel +
                ", exp=" + exp +
                ", level=" + level +
                ", email='" + email + '\'' +
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

    public Integer getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(Integer foodLevel) {
        this.foodLevel = foodLevel;
    }

    public Double getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(Double healthLevel) {
        this.healthLevel = healthLevel;
    }

    public Double getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(Double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public Float getExp() {
        return exp;
    }

    public void setExp(Float exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
