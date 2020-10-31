package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;

/**
 * 系统严重异常 - 数据库
 */
public class DBException extends FLRException{


    public DBException(Excep status) {
        super(status);
    }

    public DBException(String msg) {
        super(msg);
    }

    public DBException() {
        super("致命错误 - 连接数据库异常!");
    }

}
