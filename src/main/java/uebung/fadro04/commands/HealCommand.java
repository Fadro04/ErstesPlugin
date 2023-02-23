package uebung.fadro04.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import uebung.fadro04.IO;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (IO.isInstance(sender)) {
                return true;
            } else {
                Player player = (Player) sender;
                heal(player);
            }
        } else if (args.length == 1) {
            if (IO.isPlayer(args[0])) {
                Player target = Bukkit.getPlayerExact(args[0]);
                heal(target);
            }
        }
        return true;
    }

    public void heal(Player player) {
        player.setHealth(20);
        player.setSaturation(1);
        player.sendMessage(ChatColor.GREEN + "You got healed");
        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_HARP, 1.5f, 0.6f);
        player.spawnParticle(Particle.HEART, player.getLocation(), 5);
    }
}
