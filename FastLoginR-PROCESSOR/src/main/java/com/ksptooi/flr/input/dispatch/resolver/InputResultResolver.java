package com.ksptooi.flr.input.dispatch.resolver;

import com.ksptooi.flr.entity.model.Model;

/**
 * Input返回解析器
 */
public interface InputResultResolver {

    //进行Model解析
    boolean ResolverModel(Model model);

}
