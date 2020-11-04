package com.ksptooi.flr.proc.exception;

import com.ksptooi.flr.entity.status.ErrorStatus;

public class ParamsLengthException extends ServiceException{


    public ParamsLengthException(ErrorStatus status) {
        super(status);
    }

    public ParamsLengthException(String msg) {
        super(msg);
    }
}
