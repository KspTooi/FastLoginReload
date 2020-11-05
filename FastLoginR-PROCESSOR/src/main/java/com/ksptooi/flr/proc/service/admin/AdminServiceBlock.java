package com.ksptooi.flr.proc.service.admin;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerDetailMapper;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.proc.exception.ServiceException;
import com.ksptooi.flr.entity.status.ErrorStatus;

public class AdminServiceBlock implements AdminService {

    @Inject
    PlayerMapper mapper = null;

    @Inject
    PlayerDetailMapper detailMapper = null;


    @Override
    public FLRPlayer resetPlayerPwd(String playerName, String playerPwd) throws ServiceException {

        FLRPlayer playerByName = mapper.getPlayerByAccount(playerName);
        playerByName.setPassword(playerPwd);
        if (mapper.updatePlayer(playerByName) != 0) {
            return playerByName;
        } else {
            throw new ServiceException(ErrorStatus.FATAL_DB);
        }
    }


    /**
     * 根据玩家名称获取玩家数据对象
     *
     * @param playerName
     * @return 玩家数据对象
     */
    @Override
    public FLRPlayer getFLRPlayer(String playerName) {
        return mapper.getPlayerByAccount(playerName);
    }
}
