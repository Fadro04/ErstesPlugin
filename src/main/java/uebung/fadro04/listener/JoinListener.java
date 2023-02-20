package uebung.fadro04.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 1.5f, 0.5f);
        event.setJoinMessage(ChatColor.GREEN + "+[" +event.getPlayer().getName() + "]");
    }
}
