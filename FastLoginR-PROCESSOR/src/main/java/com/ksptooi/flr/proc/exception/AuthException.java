package com.ksptooi.flr.proc.exception;

public class AuthException extends Exception{

    private String msg = "在验证时发生异常!";

    public AuthException(){

    }

    public AuthException(String msg){
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
