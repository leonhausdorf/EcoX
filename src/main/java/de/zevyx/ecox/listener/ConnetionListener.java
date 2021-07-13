package de.zevyx.ecox.listener;

import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnetionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!EcoXAPI.getAPI().getMoneyAPI().userExists(p))
            EcoXAPI.getAPI().getMoneyAPI().initiateUser(p);
    }

}
