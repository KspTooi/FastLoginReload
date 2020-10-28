package com.ksptooi.dal;

import com.ksptooi.flr.dao.access.HibernateSqliteAccess;
import com.ksptooi.flr.entity.player.FLRPlayer;
import org.hibernate.Session;
import org.junit.Test;

public class unitest {

    @Test
    public void dbInsert(){


        //定义实体类
        FLRPlayer pl = new FLRPlayer();
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
        Session session = HibernateSqliteAccess.getSession();

/*        //开始事务
        session.beginTransaction();

        //加入实体类
        session.save(pl);

        //释放session
        session.close();*/

    }


}
