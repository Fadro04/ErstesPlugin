package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You are not a Player!");
                return true;
            }
            Player player = (Player) sender;
            setFly(player, !player.getAllowFlight());
        }

        if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            assert target != null;
            setFly(target, !target.getAllowFlight());
        }
        return true;
    }


    public void setFly(Player p, Boolean b) {
        p.setAllowFlight(b);
        p.setFlying(b);
        if (b) {
            p.sendMessage(ChatColor.GREEN + "You can now fly!");
        } else p.sendMessage(ChatColor.RED + "You can now not fly anymore!");
    }
}
