package uebung.fadro04.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uebung.fadro04.IO;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("No arguments are given, need at least one Argument");
            return true;
        }

        if (args.length == 1) {
            if (IO.isInstance(sender)) {
                return true;
            }
            Player player = (Player) sender;
            setGamemode(player, args[0]);
        } else if (args.length == 2) {
            if (IO.isPlayer(args[1])) {
                Player target = Bukkit.getPlayerExact(args[1]);
                setGamemode(target, args[0]);
            }
        }
        return true;
    }

    public void setGamemode(Player player, String playerName) {
        GameMode gameMode = GameMode.SURVIVAL;
        switch (playerName) {
            case "Creative":
            case "1":
                gameMode = GameMode.CREATIVE;
                break;
            case "Spectator":
            case "2":
                gameMode = GameMode.SPECTATOR;
                break;
            case "Adventure":
            case "3":
                gameMode = GameMode.ADVENTURE;
                break;
        }
        player.setGameMode(gameMode);
    }

}
