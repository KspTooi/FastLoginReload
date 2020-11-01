package com.ksptooi.flr.proc.exception;

import com.ksptooi.util.dictionary.Excep;
import org.bukkit.entity.Player;

public class AuthException extends ServiceException {

    private Player player = null;

    public AuthException(Excep status,Player player){
        super(status);
        this.player = player;
    }


    public AuthException(Excep status){
        super(status);
    }

    public AuthException(String msg){
        super(msg);
    }

    public AuthException(){
        super("在验证时发生异常!");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
