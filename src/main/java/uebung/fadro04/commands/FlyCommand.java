package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uebung.fadro04.IO;


public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (IO.isInstance(sender)) {
                return true;
            }
            Player player = (Player) sender;
            setFly(player, !player.getAllowFlight());
        }

        if (args.length == 1) {
            if (IO.isPlayer(args[0])) {
                Player target = Bukkit.getPlayerExact(args[0]);
                setFly(target, !target.getAllowFlight());
            }
        }
        return true;
    }


    public void setFly(Player player, Boolean isFly) {
        player.setAllowFlight(isFly);
        player.setFlying(isFly);
        if (isFly) {
            player.sendMessage(ChatColor.GREEN + "You can now fly!");
        } else player.sendMessage(ChatColor.RED + "You can now not fly anymore!");
    }
}
