package com.ksptooi.flr.module.export;

import org.mybatis.guice.XMLMyBatisModule;

public class MybatisModule extends XMLMyBatisModule {




    protected void initialize() {
        setEnvironmentId("dev");
        setClassPathResource("mybatis.cfg.xml");
    }

}
