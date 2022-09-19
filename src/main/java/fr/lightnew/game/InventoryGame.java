package fr.lightnew.game;

import fr.lightnew.tools.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryGame {

    public static ItemStack KNIFE = ItemBuilder.create(Material.IRON_SWORD, 1, ChatColor.GRAY + "Knife");
    public static ItemStack SLOT_WEAPONS_1 = ItemBuilder.create(Material.WOODEN_HOE, 1, ChatColor.YELLOW + "GUN");
    public static ItemStack SLOT_WEAPONS_2 = ItemBuilder.create(Material.CLAY_BALL, 1, ChatColor.GRAY + "WEAPON SLOT #2");
    public static ItemStack ATOUT_1 = ItemBuilder.create(Material.CLAY_BALL, 1, ChatColor.GRAY + "ATOUT #1");
    public static ItemStack ATOUT_2 = ItemBuilder.create(Material.CLAY_BALL, 1, ChatColor.GRAY + "ATOUT #2");
    public static ItemStack ATOUT_3 = ItemBuilder.create(Material.CLAY_BALL, 1, ChatColor.GRAY + "ATOUT #3");
    public static ItemStack ATOUT_4 = ItemBuilder.create(Material.CLAY_BALL, 1, ChatColor.GRAY + "ATOUT #4");

    public static void inventoryPlayer(Player player) {
        player.getInventory().clear();

        player.getInventory().setItem(0, KNIFE);
        player.getInventory().setItem(1, SLOT_WEAPONS_1);
        player.getInventory().setItem(2, SLOT_WEAPONS_2);


        player.getInventory().setItem(6, ATOUT_1);
        player.getInventory().setItem(7, ATOUT_2);
        player.getInventory().setItem(8, ATOUT_3);
        player.getInventory().setItem(9, ATOUT_4);
    }
}
