package com.ksptooi.flr.service.unit;

import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.module.export.ProcModule;
import com.ksptooi.flr.service.player.PlayerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlayerServiceUnit {


    PlayerService service = null;

    @Before
    public void before(){
        System.out.println("初始化Service");
        this.service = ProcModule.getInject().getInstance(PlayerService.class);
    }

    @Test
    public void register(){

        FLRPlayer player = new FLRPlayer();
        player.setAccount("KspTooi0");
        player.setPassword("123456");

        assertNotNull(service.playerRegister(player));
    }

    @Test
    public void login() {
        assertNotNull(service.playerLogin("KspTooi", "123456"));
    }

    @Test
    public void logout(){
        assertTrue(service.playerLogout("KspTooi"));
    }

    @Test
    public void getPlayer(){
        assertNotNull(service.getFLRPlayer("KspTooi"));
    }

}
