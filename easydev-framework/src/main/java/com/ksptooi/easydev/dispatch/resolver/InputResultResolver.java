package com.ksptooi.easydev.dispatch.resolver;


import com.ksptooi.easydev.entity.Model;
import com.ksptooi.easydev.exceptions.ServiceException;

/**
 * Input返回解析器
 */
public interface InputResultResolver {

    //进行Model解析
    boolean ResolverModel(Model model, ServiceException serviceException);


}
