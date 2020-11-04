package com.ksptooi.flr.proc.exception;

import com.ksptooi.flr.entity.status.ErrorStatus;

public class ServiceException extends Exception{

    private String msg = "发生异常!";
    private Integer errorCode = -1;

    public ServiceException(ErrorStatus status){
        this.msg = status.getMessage();
        this.errorCode = status.getErrorCode();
    }

    public ServiceException(String msg){
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
