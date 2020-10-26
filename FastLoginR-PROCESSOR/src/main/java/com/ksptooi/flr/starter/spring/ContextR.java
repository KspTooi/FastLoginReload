package com.ksptooi.flr.starter.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextR {


    public static AnnotationConfigApplicationContext acac = null;

    static{
        //加载Spring注解容器
        acac = new AnnotationConfigApplicationContext();
        acac.register(ContextConfig.class);
        acac.refresh();
    }

    //获取bean
    public static <T> T get(Class<T> bClass){
        return acac.getBean(bClass);
    }

    //获取到容器
    public static AnnotationConfigApplicationContext getContext(){
        return acac;
    }


}
