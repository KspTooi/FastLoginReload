package com.ksptooi.annotation;

import com.ksptooi.flr.input.adapter.CommandAdapter;
import com.ksptooi.flr.input.command.PlayerCommand;
import com.ksptooi.flr.input.command.PlayerCommandHandler;
import com.ksptooi.flr.module.export.ProcModule;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AdapterUnit {

    @Test
    public void adapterTest(){

        CommandAdapter adapter = ProcModule.getInject().getInstance(CommandAdapter.class);

        adapter.regHandler(PlayerCommandHandler.class);

        adapter.assign("login",null,null,null);

    }








}
