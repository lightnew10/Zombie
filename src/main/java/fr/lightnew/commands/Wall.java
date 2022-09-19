package fr.lightnew.commands;

import fr.lightnew.walls.CreateWall;
import fr.lightnew.walls.DirectionPlayer;
import fr.lightnew.walls.InfosWalls;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class Wall implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length < 2 || args.length > 3) {
                    player.sendMessage(ChatColor.RED + "How to use command ?\n" +
                            "/createwall <Small|VerySmall|Custom> <price> <name> <[\"example\"]>");
                }
                if (args.length == 2) {
                    player.sendMessage("fait args 2");
                }
                if (args.length == 3) {
                    player.sendMessage("fait args 3");
                    CreateWall wall = new CreateWall(player.getLocation(), "name", Arrays.asList("lores"));
                    wall.createHolo(player.getLocation());
                    wall.buildStructure(player, getDirectionPlayer(player), InfosWalls.SMALL);
                    wall.registerWall();
                }
            }
        }
        return false;
    }

    public DirectionPlayer getDirectionPlayer(Player player) {
        double yaw = player.getLocation().getYaw();

        if (yaw >= 315.4 && yaw <= 360 || yaw >= 0 && yaw <= 44.5)
            return DirectionPlayer.SOUTH;
        if (yaw >= 44.6 && yaw <= 134.6)
            return DirectionPlayer.WEST;
        if (yaw >= 134.7 && yaw <= 224.8)
            return DirectionPlayer.NORTH;
        if (yaw >= 224.9 && yaw <= 315.3)
            return DirectionPlayer.EAST;

        return null;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            return Arrays.asList("Small", "Very_small", "Custom");
        }

        if (args.length == 2) {
            return Arrays.asList("0");
        }

        if (args.length == 3) {
            return Arrays.asList("[\"example\"]");
        }
        return null;
    }
}
