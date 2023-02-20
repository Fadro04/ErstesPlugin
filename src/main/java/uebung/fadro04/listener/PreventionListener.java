package uebung.fadro04.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PreventionListener implements Listener {

    @EventHandler
    public void onPrevention(PlayerInteractEvent event) {
        if (!(event.getPlayer().isOp())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to build her");
        }
    }
}
