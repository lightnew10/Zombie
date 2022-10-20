package fr.lightnew.commands;

import fr.lightnew.events.PlayerManager;
import fr.lightnew.tools.HeadClick;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateHeadClick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "ERREUR -> manque un parametre <name>");
                }
                if (args.length == 1) {
                    HeadClick.createHeadClick(player, args[0], PlayerManager.skull_armorstand);
                    player.sendMessage(ChatColor.GREEN + "Vous venez de faire spawn un 'HeadClicker' nommé '" + args[0] + "'. Il apparaitra que pour vous !");
                }
            } else player.sendMessage(ChatColor.RED + "Vous êtes pas autorisé à faire cette commande");
        } else sender.sendMessage(ChatColor.RED + "Vous devez être un joueur pour faire ceci.");
        return false;
    }
}
