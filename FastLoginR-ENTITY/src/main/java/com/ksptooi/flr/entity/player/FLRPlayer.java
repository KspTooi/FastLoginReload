package com.ksptooi.flr.entity.player;


import com.ksptooi.flr.entity.status.PlayerStatus;

public class FLRPlayer {

    //玩家ID
    private Integer pid;

    //玩家凭据
    private String account;

    //玩家名称
    private String playerName;

    //玩家密码
    private String password;

    //注册日期
    private String registerDate;

    //注册IP地址
    private String registerIp;

    //授权状态
    private Integer authStatus;

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
        return "FLRPlayer{" +
                "pid=" + pid +
                ", account='" + account + '\'' +
                ", playerName='" + playerName + '\'' +
                ", password='" + password + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", registerIp='" + registerIp + '\'' +
                ", authStatus=" + authStatus +
                ", loginCount=" + loginCount +
                ", lastLoginDate='" + lastLoginDate + '\'' +
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
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

    /**
     * 玩家当前登录状态
     * @return 已登录返回true 未登录返回false
     */
    public boolean isLogin(){


        if(this.authStatus == PlayerStatus.LOGIN_SUCCESS.getCode()){
            return true;
        }

        return false;
    }

    /**
     * 玩家当前注册状态
     * @return 已注册返回true 未注册返回false
     */
    public boolean isReg(){

        if(this.authStatus == PlayerStatus.REG_SUCCESS.getCode()){
            return true;
        }

        return false;
    }

}
