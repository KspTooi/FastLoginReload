package com.ksptooi.flr.dao.test;

import com.google.inject.Injector;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.entity.status.PlayerStatus;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.flr.util.DateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;


public class PlayerMapperT {

    PlayerMapper mapper = null;


    @Before
    public void before(){
        this.mapper = ProcModule.getInject().getInstance(PlayerMapper.class);
    }


    @Test
    public void insertPlayer(){

        FLRPlayer flrPlayer = new FLRPlayer();
        flrPlayer.setAccount(UUID.randomUUID().toString());
        flrPlayer.setPlayerName(UUID.randomUUID().toString());
        flrPlayer.setPassword(UUID.randomUUID().toString());
        flrPlayer.setRegisterDate(DateUtil.getCurTimeString());
        flrPlayer.setAuthStatus(PlayerStatus.REG_SUCCESS.getCode());
        flrPlayer.setLoginCount(1);

        Assert.assertEquals("单元测试失败",1,(long)mapper.insertPlayer(flrPlayer));
    }


    @Test
    public void getPlayerById(){
        Assert.assertNotNull("单元测试失败",mapper.getPlayerById(1));
    }

    @Test
    public void getPlayerByName(){
        Assert.assertNotNull("单元测试失败",mapper.getPlayerByName("KspTooi"));
    }


    @Test
    public void removePlayer(){
        //Assert.assertEquals("单元测试失败",1,(long)mapper.removePlayer("2"));
    }

    @Test
    public void updatePlayer(){
        FLRPlayer playerById = mapper.getPlayerById(1);
        Assert.assertEquals("单元测试失败",1,(long)mapper.updatePlayer(playerById));
    }


}
