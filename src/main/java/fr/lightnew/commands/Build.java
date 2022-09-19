package fr.lightnew.commands;

import fr.lightnew.ZombieMain;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class Build implements CommandExecutor {

    public static List<Player> build = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (build.contains(player)) {
                    build.remove(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Vous êtes plus en BuildMod"));
                } else {
                    build.add(player);
                    BukkitTask task = new BukkitRunnable() {

                        @Override
                        public void run() {
                            if (build.contains(player))
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "Vous êtes en BuildMod"));
                            else cancel();
                        }
                    }.runTaskTimer(ZombieMain.instance, 0, 20);
                }
            }
        }
        return false;
    }
}
