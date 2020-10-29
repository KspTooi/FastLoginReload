package com.ksptooi.flr.starter.dao.unit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.module.export.DalModule;
import org.junit.Test;

public class DaoInjectTest {


    @Test
    public void test(){

        /*Injector injector = Guice.createInjector(new DalModule());*/

        Injector inject = DalModule.getInject();

        MybatisAccess instance = inject.getInstance(MybatisAccess.class);

        PlayerMapper instance1 = inject.getInstance(PlayerMapper.class);

        System.out.println(instance1);

        FLRPlayer playerById = instance1.getPlayerById(1);

        System.out.println(playerById);

    }

}
