package com.ksptooi.flr.entity.status;

public enum AuthState{



    REG_UNDONE("未注册",100)
    ,REG_DONE("已注册",101)

    ,LOGIN_UNDONE("未登录",200)
    ,LOGIN_DONE("已登录",201)

    ,BAN("被封禁",300)

    ;



    AuthState(String desc, int code) {
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
