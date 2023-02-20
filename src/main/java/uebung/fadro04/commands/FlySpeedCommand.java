package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlySpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need to type in a number between 0 and 10");
            return true;
        } else if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "The Console can not fly!");
                return true;
            }
            Player p = (Player) sender;
            setFlySpeed(p, args[0]);
        } else if (args.length == 2) {
            Player t = Bukkit.getPlayerExact(args[0]);
            setFlySpeed(t, args[1]);
        }
        return true;
    }


    public void setFlySpeed(Player p, String arg) {
        float f = Float.parseFloat(arg);
        if (f != 0 && f <= 10) {
            f = f / 10;
            p.setFlySpeed(f);
            p.sendMessage("FlySpeed set to " + arg);
        }
        if (f == 0) {
            p.setFlySpeed(0);
        }
        if (f > 10 || f < -10) {
            p.sendMessage(ChatColor.RED + "The Maximum Flight Speed is 10");
        }

    }
}
