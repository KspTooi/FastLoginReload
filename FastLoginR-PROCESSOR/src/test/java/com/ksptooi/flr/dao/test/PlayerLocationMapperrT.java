package com.ksptooi.flr.dao.test;

import com.ksptooi.flr.entity.player.PlayerLocation;
import com.ksptooi.flr.mapper.player.PlayerDetailMapper;
import com.ksptooi.flr.mapper.player.PlayerLocationMapper;
import com.ksptooi.flr.proc.module.export.ProcModule;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerLocationMapperrT {

    PlayerLocationMapper mapper = null;


    @Before
    public void before(){
        this.mapper = ProcModule.getInject().getInstance(PlayerLocationMapper.class);
    }


    @Test
    public void getLocationByPID(){
        Assert.assertNotNull(mapper.getLocationByPID(1));
    }


    @Test
    public void insertLocation(){
        PlayerLocation loc = new PlayerLocation();
        loc.setPid(2);
        Assert.assertEquals(1,(long)mapper.insertLocation(loc));
    }

    @Test
    public void removeLocation(){
        //
    }

    @Test
    public void updateLocation(){
        PlayerLocation loc = mapper.getLocationByPID(1);
        Assert.assertEquals(1,(long)mapper.updateLocation(loc));
    }




}
