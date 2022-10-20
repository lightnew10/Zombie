package fr.lightnew;

import fr.lightnew.commands.Build;
import fr.lightnew.commands.CreateHeadClick;
import fr.lightnew.events.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ZombieMain extends JavaPlugin {

    public static ZombieMain instance;
    public static String PREFIX = ChatColor.GRAY+ "[" +ChatColor.YELLOW + "Zombie-Back-4-Bloods" + ChatColor.GRAY + "]";

    @Override
    public void onEnable() {
        instance = this;
        log(PREFIX + ChatColor.GREEN + " is Enable");

        //TODO LISTENERS
        PluginManager plugin = Bukkit.getPluginManager();
        plugin.registerEvents(new PlayerManager(), this);

        //TODO COMMANDS
        getCommand("build").setExecutor(new Build());
        getCommand("headclick").setExecutor(new CreateHeadClick());
    }

    @Override
    public void onDisable() {
        log(PREFIX + ChatColor.RED + " is Enable");
    }

    public static void log(String s) {Bukkit.getConsoleSender().sendMessage(s);}
}
