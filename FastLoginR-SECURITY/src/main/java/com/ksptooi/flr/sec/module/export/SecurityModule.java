package com.ksptooi.flr.sec.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.ksptooi.flr.sec.thread.PlayerMessageQueue;

public class SecurityModule extends AbstractModule {


    @Override
    protected void configure() {
        //玩家消息队列
        bind(PlayerMessageQueue.class).in(Scopes.SINGLETON);
    }


}
