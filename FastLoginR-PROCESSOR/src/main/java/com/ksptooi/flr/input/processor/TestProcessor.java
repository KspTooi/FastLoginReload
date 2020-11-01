package com.ksptooi.flr.input.processor;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import org.bukkit.command.CommandSender;

@Processor
@ProcessMapper("testProc")
public class TestProcessor {


    @ProcessMapper("cmd")
    public Model testCommandProcessor(@Params("params")String[] p){

        for(String e:p){
            System.out.println(e);
        }

        System.out.println("这是一个测试处理器11111");

        return null;
    }


}
