package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class NotFoundHandlerException extends ProcException{


    public NotFoundHandlerException(Excep status) {
        super(status);
    }

    public NotFoundHandlerException(String msg) {
        super(msg);
    }

}
