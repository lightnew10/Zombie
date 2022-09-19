package fr.lightnew.events;

import fr.lightnew.ZombieMain;
import fr.lightnew.commands.Build;
import fr.lightnew.game.InventoryGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.Date;

public class PlayerManager implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        InventoryGame.inventoryPlayer(player);
    }

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
    }

    @EventHandler
    public void inventoryCLick(InventoryClickEvent event) {event.setCancelled(!Build.build.contains((Player) event.getWhoClicked()));}

    @EventHandler
    public void food(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void breakBlock(BlockBreakEvent event) {
        event.setCancelled(!Build.build.contains(event.getPlayer()));
    }

    @EventHandler
    public void placeBlock(BlockPlaceEvent event) {
        event.setCancelled(!Build.build.contains(event.getPlayer()));
    }

    @EventHandler
    public void drop(PlayerDropItemEvent event) {
        event.setCancelled(!Build.build.contains(event.getPlayer()));
    }

    @EventHandler
    public void pickUp(PlayerPickupItemEvent event) {
        event.setCancelled(!Build.build.contains(event.getPlayer()));
    }
}
