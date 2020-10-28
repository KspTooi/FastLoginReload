package com.ksptooi.flr.module.export;


import com.google.inject.AbstractModule;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.dao.access.MybatisSqliteAccess;

public class DalModule extends AbstractModule {


    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    protected void configure() {

        bind(MybatisAccess.class).to(MybatisSqliteAccess.class);

    }
}
