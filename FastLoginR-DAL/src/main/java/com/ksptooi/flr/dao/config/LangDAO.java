package com.ksptooi.flr.dao.config;

import com.ksptooi.flr.entity.config.PluginConfig;
import com.ksptooi.flr.entity.language.PluginLang;

/**
 * 语言文件DAO
 */
public interface LangDAO {

    /**
     * 取语言
     * @return 语言实例
     */
    PluginLang getPluginLang();

    /**
     * 更新语言
     * @return 成功返回true 失败返回false
     */
    boolean updatePluginLang();

    /**
     * 生成语言
     * @return 成功返回true 失败返回false
     */
    boolean generatorLang();



}
