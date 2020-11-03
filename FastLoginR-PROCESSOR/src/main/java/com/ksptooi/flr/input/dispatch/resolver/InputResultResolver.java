package com.ksptooi.flr.input.dispatch.resolver;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.proc.exception.ServiceException;

/**
 * Input返回解析器
 */
public interface InputResultResolver {

    //进行Model解析
    boolean ResolverModel(Model model,ServiceException serviceException);


}
