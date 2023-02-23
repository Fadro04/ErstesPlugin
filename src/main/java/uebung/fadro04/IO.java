package uebung.fadro04;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IO {
    public static Boolean isInstance (CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You are not a Player!");
            return true;
        }
        return false;
    }

    public static Boolean isPlayer (String name) {
        if (Bukkit.getOnlinePlayers().contains(name)) {
            return true;
        }
        return false;
    }
}
