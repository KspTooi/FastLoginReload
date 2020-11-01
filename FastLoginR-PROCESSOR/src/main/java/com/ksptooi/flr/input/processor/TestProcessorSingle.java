package com.ksptooi.flr.input.processor;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;

import java.util.Arrays;

@Processor
@ProcessMapper("testProc")
public class TestProcessorSingle {

    @ProcessMapper("cmd")
    public Model testCommandProcessor(@Params("params")String[] p
                                     ,@Params("model")Model model
                                     ,@Params("name")String name){


        model.addMessage("这是一个测试处理器222222");
        model.addMessage("玩家命令名:"+name);
        model.addMessage("参数:" + Arrays.toString(p));

        System.out.println("这是一个测试处理器222222");
        System.out.println("玩家命令名:"+name);
        System.out.println("参数:" + Arrays.toString(p));

        System.out.println("这是一个测试处理器222222");

        return model;
    }


}
