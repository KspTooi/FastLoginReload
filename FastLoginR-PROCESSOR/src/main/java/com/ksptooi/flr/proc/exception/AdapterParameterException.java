package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class AdapterParameterException extends ServiceException{

    public AdapterParameterException(Excep status) {
        super(status);
    }

    public AdapterParameterException(String msg) {
        super(msg);
    }

}
