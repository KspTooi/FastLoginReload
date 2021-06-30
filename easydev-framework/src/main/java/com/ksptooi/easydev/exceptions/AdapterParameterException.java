package com.ksptooi.easydev.exceptions;


import com.ksptooi.easydev.enums.ErrorStatus;

public class AdapterParameterException extends ServiceException{

    public AdapterParameterException(ErrorStatus status) {
        super(status);
    }

    public AdapterParameterException(String msg) {
        super(msg);
    }

}
