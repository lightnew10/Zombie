package fr.lightnew;

import fr.lightnew.commands.Build;
import fr.lightnew.commands.Wall;
import fr.lightnew.events.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ZombieMain extends JavaPlugin {

    public static ZombieMain instance;
    public File folderDoor = new File(getDataFolder().getPath(), "IDDoor");
    public File folderCachePlayer = new File(getDataFolder().getPath(), "CachesPlayers");
    public static String PREFIX = ChatColor.GRAY+ "[" +ChatColor.YELLOW + "Zombie" + ChatColor.GRAY + "]";

    @Override
    public void onEnable() {
        instance = this;
        log(PREFIX + ChatColor.GREEN + " is Enable");
        saveDefaultConfig();
        createFolders();
        /*--------------------------------------------*/
        //TODO LISTENERS
        PluginManager plugin = Bukkit.getPluginManager();
        plugin.registerEvents(new PlayerManager(), this);
        //TODO COMMANDS
        getCommand("build").setExecutor(new Build());
        getCommand("createwall").setExecutor(new Wall());
        getCommand("createwall").setTabCompleter(new Wall());
    }

    @Override
    public void onDisable() {
        log(PREFIX + ChatColor.RED + " is Enable");
        if (folderCachePlayer.exists())
            folderCachePlayer.delete();

    }

    public void createFolders() {
        if (!folderDoor.exists()) {
            if (folderDoor.mkdir())
                log(ChatColor.GREEN + "Creating folder \"IDDoor\"");
            else
                log(ChatColor.RED + "ERROR -> error creating this folder \"IDDoor\"");
        }
        if (!folderCachePlayer.exists()) {
            if (folderCachePlayer.mkdir())
                log(ChatColor.GREEN + "Creating folder \"CachesPlayers\"");
            else
                log(ChatColor.RED + "ERROR -> error creating this folder \"CachesPlayers\"");
        }
    }

    public static void log(String s) {Bukkit.getConsoleSender().sendMessage(s);}
}
