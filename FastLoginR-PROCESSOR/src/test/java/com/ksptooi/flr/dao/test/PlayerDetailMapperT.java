package com.ksptooi.flr.dao.test;

import com.ksptooi.flr.entity.player.PlayerDetail;
import com.ksptooi.flr.mapper.player.PlayerDetailMapper;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.proc.module.export.ProcModule;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerDetailMapperT {

    PlayerDetailMapper mapper = null;


    @Before
    public void before(){
        this.mapper = ProcModule.getInject().getInstance(PlayerDetailMapper.class);
    }

    @Test
    public void getDetailByPID(){
        Assert.assertNotNull(mapper.getDetailByPID("1"));
    }

    @Test
    public void insertDetail(){
        PlayerDetail playerDetail = new PlayerDetail();
        playerDetail.setPid(2);
        Assert.assertEquals(1,(long)mapper.insertDetail(playerDetail));
    }

    @Test
    public void removeDetail(){
        //
    }


    @Test
    public void updateDetail(){
        PlayerDetail detailByPID = mapper.getDetailByPID("1");
        Assert.assertEquals(1,(long)mapper.updateDetail(detailByPID));
    }



}
