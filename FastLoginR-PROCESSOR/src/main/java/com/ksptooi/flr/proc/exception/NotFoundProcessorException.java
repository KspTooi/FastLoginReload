package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

public class NotFoundProcessorException extends ServiceException {


    public NotFoundProcessorException(Excep status) {
        super(status);
    }

    public NotFoundProcessorException(String msg) {
        super(msg);
    }

}
