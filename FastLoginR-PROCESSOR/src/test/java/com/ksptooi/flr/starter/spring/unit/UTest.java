package com.ksptooi.flr.starter.spring.unit;

import com.ksptooi.flr.dal.player.PlayerDAO;
import com.ksptooi.flr.service.player.PlayerService;
import com.ksptooi.flr.starter.spring.ContextR;
import org.junit.Test;

public class UTest {


    @Test
    public void springContextTest(){

        PlayerService playerService = ContextR.get(PlayerService.class);
        playerService.playerRegister(null);
        System.out.println(playerService);
    }


}
