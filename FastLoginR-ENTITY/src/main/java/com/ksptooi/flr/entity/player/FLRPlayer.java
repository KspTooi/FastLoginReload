package com.ksptooi.flr.entity.player;

public class FLRPlayer {

    //玩家ID
    private Integer pid;

    //玩家名称
    private String account;

    //玩家密码
    private String password;

    //当前注册状态
    private Integer registerStatus;

    //注册日期
    private String registerDate;

    //注册IP地址
    private String registerIp;

    //当前登录状态
    private Integer loginStatus;

    //登录次数
    private Integer loginCount;

    //最后登录日期
    private String lastLoginDate;

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
                ", registerstatus=" + registerStatus +
                ", registerDate='" + registerDate + '\'' +
                ", registerip='" + registerIp + '\'' +
                ", loginstatus=" + loginStatus +
                ", logincount=" + loginCount +
                ", lastloginDate='" + lastLoginDate + '\'' +
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

    public Integer getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(Integer registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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
