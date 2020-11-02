package com.ksptooi.flr.proc.adapter;

import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.module.export.ProcModule;
import org.junit.Test;

public class AdapterTest {


    @Test
    public void AdapterFind() throws AdapterParameterException, NotFoundProcessorException {

        StepInputAdapter instance = ProcModule.getInject().getInstance(StepInputAdapter.class);
/*        instance.regHandler(TestProcessor.class);
        instance.regHandler(TestProcessorSingle.class);*/

        String[] para = {"cmd"};

        InputProcessor ip = instance.findProcessor("testProc", null, null, null, para);

        ip.start();


    }




}
