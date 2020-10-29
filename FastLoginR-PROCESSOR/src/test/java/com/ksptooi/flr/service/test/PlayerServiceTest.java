package com.ksptooi.flr.service.test;


import com.google.inject.Injector;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.module.export.ProcModule;
import com.ksptooi.flr.service.player.PlayerService;
import org.junit.Test;

/**
 * 测试玩家服务类
 */
public class PlayerServiceTest {


    //注册玩家
    @Test
    public void regPlayer(){

        PlayerService playerService = ProcModule.getInject().getInstance(PlayerService.class);

        FLRPlayer player = new FLRPlayer();
        player.setAccount("KspTooi");
        player.setPassword("123456");

        playerService.playerRegister(player);

    }


}
