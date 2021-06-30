package com.ksptooi.easydev.exceptions;

import com.ksptooi.flr.entity.status.ErrorStatus;

/**
 * 玩家状态更新异常
 */
public class StateUpdateException extends ServiceException{

    public StateUpdateException(ErrorStatus status) {
        super(status);
    }

    public StateUpdateException(String msg) {
        super(msg);
    }

}
