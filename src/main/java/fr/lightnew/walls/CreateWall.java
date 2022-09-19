package fr.lightnew.walls;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.List;

public class CreateWall extends BuildWall{

    public Location location;
    public String name;
    public List<String> lore;

    public CreateWall(Location loc, String name, List<String> lore) {
        this.location=loc;
        this.name=name;
        this.lore=lore;
    }

    //*GETTER*//
    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    //*SETTER*//
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public ArmorStand createHolo(Location locHolo) {
        ArmorStand armorStand = location.getWorld().spawn(locHolo, ArmorStand.class);
        armorStand.setBasePlate(false);
        armorStand.setArms(false);
        armorStand.setVisible(false);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);
        armorStand.setPersistent(true);
        armorStand.setCustomNameVisible(true);
        if (name == null)
            name = "Default name";
        if (lore == null)
            armorStand.setCustomName(name);
        else
            armorStand.setCustomName(name + lore);
        return armorStand;
    }

    public void buildStructure(Player player, DirectionPlayer directionPlayer, InfosWalls infosWalls) {
        Location loc = player.getLocation();
        switch (directionPlayer) {
            case NORTH:
                loc.add(0.0,0,1.0);
                break;

            case SOUTH:
                loc.add(0.0,0,-1.0);
                break;

            case EAST:
                loc.add(1.0,0,0.0);
                break;

            case WEST:
                loc.add(-1.0,0,0.0);
                break;
        }
    }

    public void registerWall() {

    }
}
