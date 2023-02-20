package uebung.fadro04.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("The console can not heal!");
                return true;
            } else {
                Player p = (Player) sender;
                heal(p);
            }
        } else if (args.length == 1) {
            Player t = Bukkit.getPlayerExact(args[0]);
            heal(t);
        }
        return true;
    }
    public void heal(Player p) {
        p.setHealth(20);
        p.sendMessage(ChatColor.GREEN + "You got healed");
        p.playSound(p, Sound.BLOCK_NOTE_BLOCK_HARP, 1.5f, 0.6f);
        p.spawnParticle(Particle.HEART, p.getLocation(), 5);
    }
}
