package com.ksptooi.flr.starter.dao.unit;

import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.proc.module.export.DalModule;
import org.junit.Test;

public class H2DatabaseTest {

    @Test
    public void H2T(){

        //DalModule.install(DatabaseType.H2);
        Injector inject = DalModule.getInject();

        PlayerMapper instance = inject.getInstance(PlayerMapper.class);

        FLRPlayer playerById = instance.getPlayerByAccount("KspTooi");
        System.out.println(playerById);

/*        try{

            Class.forName("org.h2.Driver");

            String url = "jdbc:h2:C:/db";
            System.out.println("db url "+url);
            Connection conn = DriverManager.getConnection(url);
            System.out.println(conn.getMetaData().getDriverVersion());

        }catch (Exception e){
            e.printStackTrace();
        }*/


    }

}
