package com.ksptooi.easydev.exceptions;


import com.ksptooi.easydev.enums.ErrorStatus;

public class NotFoundProcessorException extends ServiceException {


    public NotFoundProcessorException(ErrorStatus status) {
        super(status);
    }

    public NotFoundProcessorException(String msg) {
        super(msg);
    }

}
