package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

/**
 * 系统严重异常 - 数据库
 */
public class DBException extends RuntimeException{


    private String msg = "严重异常,数据库连接失败!";
    private Integer errorCode = 509;

    public DBException(){
        this.msg = Excep.FATAL_DB.getMessage();
        this.errorCode = Excep.FATAL_DB.getErrorCode();
    }


    public DBException(Excep status){
        this.msg = status.getMessage();
        this.errorCode = status.getErrorCode();
    }

    public DBException(String msg){
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
