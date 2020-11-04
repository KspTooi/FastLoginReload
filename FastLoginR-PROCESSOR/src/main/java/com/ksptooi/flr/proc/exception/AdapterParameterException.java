package com.ksptooi.flr.proc.exception;

import com.ksptooi.flr.entity.status.ErrorStatus;

public class AdapterParameterException extends ServiceException{

    public AdapterParameterException(ErrorStatus status) {
        super(status);
    }

    public AdapterParameterException(String msg) {
        super(msg);
    }

}
