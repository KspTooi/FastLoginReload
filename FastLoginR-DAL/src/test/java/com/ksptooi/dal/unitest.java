package com.ksptooi.dal;

import com.ksptooi.dal.util.MysqlUtil;
import com.ksptooi.dal.util.SqliteUtil;
import com.ksptooi.entity.dto.player.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class unitest {

    @Test
    public void dbInsert(){


        //定义实体类
        Player pl = new Player();
        pl.setAccount("KspTooi");
        pl.setLastloginDate("1");
        pl.setLeaveDate("1");
        pl.setLogincount(1);
        pl.setLoginstatus(1);
        pl.setPassword("1");
        pl.setRegisterDate("1");
        pl.setRegisterip("1");
        pl.setRegisterstatus(1);


        //取到Session
        Session session = SqliteUtil.getSession();

        //开始事务
        session.beginTransaction();

        //加入实体类
        session.save(pl);

        //释放session
        session.close();

    }


}
