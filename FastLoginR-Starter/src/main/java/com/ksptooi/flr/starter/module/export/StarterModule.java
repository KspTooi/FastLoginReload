package com.ksptooi.flr.starter.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksptooi.flr.proc.module.export.DalModule;
import com.ksptooi.flr.proc.module.export.NDALModule;
import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.flr.sec.module.export.SecurityModule;
import com.ksptooi.flr.starter.bukkit.FastLoginBukkitStarter;

public class StarterModule extends AbstractModule {


    private static Injector injector = null;


    @Override
    protected void configure() {

    }

    public static Injector getInjector(){

        if(injector!=null){
            return injector;
        }

        injector = Guice.createInjector(NDALModule.getModule()
                ,ProcModule.getModule()
                ,SecurityModule.getModule(FastLoginBukkitStarter.mainClass)
        );

        return injector;
    }

}
