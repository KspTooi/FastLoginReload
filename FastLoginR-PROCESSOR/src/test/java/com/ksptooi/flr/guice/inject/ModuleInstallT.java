package com.ksptooi.flr.guice.inject;

import com.google.inject.Injector;
import com.ksptooi.flr.proc.module.export.DalModule;
import org.junit.Test;

/**
 * 模块整合测试
 */
public class ModuleInstallT {


    @Test
    public void moduleInstallTest(){



        Injector dalInject = DalModule.getInject();

  /*      dalInject.*/

/*        Injector injector = Guice.createInjector();
        injector.createChildInjector();*/

    }


}
