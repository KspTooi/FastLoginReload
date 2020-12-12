package com.ksptooi.flr.input.processor;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;

import java.util.Arrays;

@Processor
@ProcessMapper("flr")
public class TestProcessor {


    @ProcessMapper("testProcessor")
    public Model test(@Params("model")Model model,@Params("params")String[] p){

        System.out.println("测试处理器");
        System.out.println(Arrays.toString(p));

        return model;
    }

    @ProcessMapper("testCommand")
    public Model testCommand(@Params("model")Model model,@Params("params")String[] p){

        model.addMessage("这是一条测试命令");

        return model;
    }


}
