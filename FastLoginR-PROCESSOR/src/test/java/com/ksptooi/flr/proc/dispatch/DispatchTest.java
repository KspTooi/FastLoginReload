package com.ksptooi.flr.proc.dispatch;

import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.input.dispatch.InputDispatch;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.input.processor.TestProcessor;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.module.export.ProcModule;
import org.junit.Test;

public class DispatchTest {


    @Test
    public void Dispatch() throws AdapterParameterException, NotFoundProcessorException {

        InputDispatch instance = ProcModule.getInject().getInstance(InputDispatch.class);
/*        instance.regHandler(TestProcessor.class);
        instance.regHandler(TestProcessorSingle.class);*/

        instance.regProcessor(TestProcessor.class);


        String[] para = {"cmd"};

        boolean testProc = instance.dispatchInputCommand("testProcessor", null, null, null, para);

        System.out.println("调度器返回结果:"+testProc);


    }









}
