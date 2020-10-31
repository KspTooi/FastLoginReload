package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class FLRException extends Exception{

    private String msg = "发生异常!";
    private Integer errorCode = -1;


    public FLRException(Excep status){
        this.msg = status.getMessage();
        this.errorCode = status.getErrorCode();
    }

    public FLRException(String msg){
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
