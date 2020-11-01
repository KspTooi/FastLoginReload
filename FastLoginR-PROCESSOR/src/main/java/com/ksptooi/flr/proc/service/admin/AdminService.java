package com.ksptooi.flr.proc.service.admin;

import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.proc.exception.ServiceException;

/**
 * 管理员服务类
 */
public interface AdminService {

    /**
     *
     * @param playerName
     * @param playerPwd
     * @return
     */
    FLRPlayer resetPlayerPwd(String playerName,String playerPwd)throws ServiceException;


}
