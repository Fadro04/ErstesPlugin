package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("No arguments are given, need at least one Argument");
            return true;
        }

        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("The console can not change the game mode");
                return true;
            }
            Player p = (Player) sender;
            setGamemode(p, args[0]);
        } else if (args.length == 2) {
            Player t = Bukkit.getPlayerExact(args[1]);
            setGamemode(t, args[0]);
        }
        return true;
    }

    public void setGamemode(Player p, String arg) {
        GameMode gm = GameMode.SURVIVAL;
        switch (arg) {
            case "Creative":
            case "1":
                gm = GameMode.CREATIVE;
                break;
            case "Spectator":
            case "2":
                gm = GameMode.SPECTATOR;
                break;
            case "Adventure":
            case "3":
                gm = GameMode.ADVENTURE;
                break;
        }
        p.setGameMode(gm);
    }

}
