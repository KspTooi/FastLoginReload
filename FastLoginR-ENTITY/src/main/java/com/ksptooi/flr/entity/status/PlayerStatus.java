package com.ksptooi.flr.entity.status;

public enum PlayerStatus {


    REG_FAILED("未注册",0)
    ,REG_SUCCESS("已注册",1)

    ,LOGIN_FAILED("未登录",0)
    ,LOGIN_SUCCESS("已登录",1)

    ;



    PlayerStatus(String desc, int code) {
        this.descript = desc;
        this.code = code;
    }

    private String descript = null;
    private int code = -1;

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
