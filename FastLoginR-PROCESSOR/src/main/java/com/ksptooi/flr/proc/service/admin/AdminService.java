package com.ksptooi.flr.proc.service.admin;

import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.proc.exception.ServiceException;

/**
 * 管理员服务类
 */
public interface AdminService {


    /**
     * 管理员修改玩家密码
     * @param playerName
     * @param playerPwd
     * @return 成功返回玩家实例,失败返回NULL
     * @throws ServiceException 修改失败时抛出该异常
     */
    FLRPlayer resetPlayerPwd(String playerName,String playerPwd)throws ServiceException;

    /**
     * 根据玩家名称获取玩家数据对象
     * @param playerName
     * @return 玩家数据对象
     */
    FLRPlayer getFLRPlayer(String playerName);


}
