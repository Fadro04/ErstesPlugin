package uebung.fadro04;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import uebung.fadro04.commands.*;
import uebung.fadro04.listener.JoinListener;
import uebung.fadro04.listener.PreventionListener;
import uebung.fadro04.listener.QuitListener;

import java.util.Objects;

public final class Fadro04 extends JavaPlugin {

    @Override
    public void onEnable() {
        log(ChatColor.GREEN + "Plugin loaded");
        register();
    }

    @Override
    public void onDisable() {
        log(ChatColor.RED + "Plugin unloaded");
    }

    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(text);
    }
    public void register() {
        //Commands
        Objects.requireNonNull(Bukkit.getPluginCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("gamemode")).setExecutor(new GamemodeCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("flySpeed")).setExecutor(new FlySpeedCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("kit")).setExecutor(new KitCommand());

        //Listener
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new PreventionListener(), this);
    }
}
