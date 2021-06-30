package com.ksptooi.easydev.exceptions;

import com.ksptooi.flr.entity.status.ErrorStatus;

public class ParamsLengthException extends ServiceException {


    public ParamsLengthException(ErrorStatus status) {
        super(status);
    }

    public ParamsLengthException(String msg) {
        super(msg);
    }
}
