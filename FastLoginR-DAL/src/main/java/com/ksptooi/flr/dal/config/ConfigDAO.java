package com.ksptooi.flr.dal.config;


import com.ksptooi.flr.entity.config.PluginConfig;

/**
 * 配置文件DAO
 */
public interface ConfigDAO {

    /**
     * 取配置项
     * @return 配置项实例
     */
    PluginConfig getPluginConfig();

    /**
     * 更新配置项
     * @return 成功返回true 失败返回false
     */
    boolean updatePluginConfig();

    /**
     * 生成配置项
     * @return 成功返回true 失败返回false
     */
    boolean generatorConfig();


}
