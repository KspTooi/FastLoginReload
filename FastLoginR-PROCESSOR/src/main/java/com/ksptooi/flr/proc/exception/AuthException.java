package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class AuthException extends ProcException {

    public AuthException(Excep status){
        super(status);
    }

    public AuthException(String msg){
        super(msg);
    }

    public AuthException(){
        super("在验证时发生异常!");
    }

}
