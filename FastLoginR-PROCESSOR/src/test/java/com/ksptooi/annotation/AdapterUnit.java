package com.ksptooi.annotation;

import com.ksptooi.flr.input.adapter.CommandAdapter;
import com.ksptooi.flr.input.command.PlayerCommandHandler;
import com.ksptooi.flr.module.export.ProcModule;
import org.junit.Test;

public class AdapterUnit {

    @Test
    public void adapterTest(){

        CommandAdapter adapter = ProcModule.getInject().getInstance(CommandAdapter.class);

        adapter.regHandler(PlayerCommandHandler.class);

        adapter.assign("login",null,null,null,null);

    }








}
