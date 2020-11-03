package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class DispatchException extends ServiceException{


    public DispatchException(Excep status) {
        super(status);
    }

    public DispatchException(String msg) {
        super(msg);
    }
}
