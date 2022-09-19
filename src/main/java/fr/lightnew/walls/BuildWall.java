package fr.lightnew.walls;

import org.bukkit.Location;
import org.bukkit.Material;

public class BuildWall {

    public void smallBuild(Location location) {

    }

    public void very_small(Location location) {
        location.getBlock().setType(Material.IRON_BLOCK);
        for (int i = -1; i < 2; i++) {
            //si differente direction du joueur ajouter ou enlever dans la location de base à fin de faire un carré
            location.add(i==1 ? /*vrai*/1:/*faux*/0, i, 0).getBlock().setType(Material.IRON_BLOCK);
            location.add(i==1 ? /*vrai*/1:/*faux*/0, i, 0).getBlock().setType(Material.IRON_BLOCK);
            location.add(i==1 ? /*vrai*/1:/*faux*/0, i, 0).getBlock().setType(Material.IRON_BLOCK);
        }
    }
}
