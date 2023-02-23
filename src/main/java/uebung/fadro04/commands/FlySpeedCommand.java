package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uebung.fadro04.IO;

public class FlySpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need to type in a number between 0 and 10");
            return true;
        } else if (args.length == 1) {
            if (IO.isInstance(sender)) {
                return true;
            }
            Player player = (Player) sender;
            setFlySpeed(player, args[0]);
        } else if (args.length == 2) {
            if (IO.isPlayer(args[0])) {
                Player target = Bukkit.getPlayerExact(args[0]);
                setFlySpeed(target, args[1]);
            }
        }
        return true;
    }


    public void setFlySpeed(Player player, String playerName) {
        float f = Float.parseFloat(playerName);
        if (f != 0 && f <= 10) {
            f = f / 10;
            player.setFlySpeed(f);
            player.sendMessage("FlySpeed set to " + playerName);
        }
        if (f == 0) {
            player.setFlySpeed(0);
        }
        if (f > 10 || f < -10) {
            player.sendMessage(ChatColor.RED + "The Maximum Flight Speed is 10");
        }

    }
}
