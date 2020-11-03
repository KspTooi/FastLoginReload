package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class ParamsLengthException extends ServiceException{


    public ParamsLengthException(Excep status) {
        super(status);
    }

    public ParamsLengthException(String msg) {
        super(msg);
    }
}
