package com.ksptooi.flr.service.unit;

import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.flr.proc.exception.AuthException;
import com.ksptooi.flr.proc.service.player.PlayerCommandService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlayerServiceUnit {


    PlayerCommandService service = null;

    @Before
    public void before(){
        System.out.println("初始化Service");
        this.service = ProcModule.getInject().getInstance(PlayerCommandService.class);
    }

    @Test
    public void register() throws AuthException {

        FLRPlayer player = new FLRPlayer();
        player.setAccount("KspTooi0");
        player.setPassword("123456");

        assertNotNull(service.playerRegister(player));
    }

    @Test
    public void login() throws AuthException {
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
