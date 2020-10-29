package com.ksptooi.flr.starter.dao.unit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.module.export.DalModule;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoInjectTest {


    @Test
    public void test(){

        /*Injector injector = Guice.createInjector(new DalModule());*/


        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:plugins/sqlite3.db";
            System.out.println("db url "+url);
            Connection conn = DriverManager.getConnection(url);
            System.out.println(conn.getMetaData().getDriverVersion());

        } catch (Exception e) {
            e.printStackTrace();
        }

/*        DalModule.install(DatabaseType.SQLITE);

        Injector inject = DalModule.getInject();

        PlayerMapper instance1 = inject.getInstance(PlayerMapper.class);

        System.out.println(instance1);

        FLRPlayer playerById = instance1.getPlayerById(1);

        System.out.println(playerById);*/

    }

}
