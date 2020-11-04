package com.ksptooi.flr.proc.exception;

import com.ksptooi.flr.entity.status.ErrorStatus;

public class NotFoundProcessorException extends ServiceException {


    public NotFoundProcessorException(ErrorStatus status) {
        super(status);
    }

    public NotFoundProcessorException(String msg) {
        super(msg);
    }

}
