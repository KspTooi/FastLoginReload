package com.ksptooi.entity.dto.player;

public class Player {

    //玩家ID
    private Integer pid;

    //玩家名称
    private String account;

    //玩家密码
    private String password;

    //当前注册状态
    private Integer registerstatus;

    //注册日期
    private String registerDate;

    //注册IP地址
    private String registerip;

    //当前登录状态
    private Integer loginstatus;

    //登录次数
    private Integer logincount;

    //最后登录日期
    private String lastloginDate;

    //最后离开日期
    private String leaveDate;

    //玩家属性
    private PlayerDetail playerDetail = null;

    //玩家位置
    private PlayerLocation playerLocation = null;

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", registerstatus=" + registerstatus +
                ", registerDate='" + registerDate + '\'' +
                ", registerip='" + registerip + '\'' +
                ", loginstatus=" + loginstatus +
                ", logincount=" + logincount +
                ", lastloginDate='" + lastloginDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", playerDetail=" + playerDetail +
                ", playerLocation=" + playerLocation +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRegisterstatus() {
        return registerstatus;
    }

    public void setRegisterstatus(Integer registerstatus) {
        this.registerstatus = registerstatus;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterip() {
        return registerip;
    }

    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    public Integer getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(Integer loginstatus) {
        this.loginstatus = loginstatus;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public String getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(String lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public PlayerDetail getPlayerDetail() {
        return playerDetail;
    }

    public void setPlayerDetail(PlayerDetail playerDetail) {
        this.playerDetail = playerDetail;
    }

    public PlayerLocation getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(PlayerLocation playerLocation) {
        this.playerLocation = playerLocation;
    }
}
