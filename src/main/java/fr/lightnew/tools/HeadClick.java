package fr.lightnew.tools;

import fr.lightnew.ZombieMain;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class HeadClick {

    public static EntityArmorStand createHeadClick(Player player, String name, ItemStack skull) {
        //NE SPAWN PAS
        WorldServer s = ((CraftWorld)player.getWorld()).getHandle();
        EntityArmorStand armorStand = new EntityArmorStand(EntityTypes.ARMOR_STAND, s);
        Location location = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        double baseY = location.getY();

        armorStand.setCustomNameVisible(true);
        armorStand.setNoGravity(true);
        armorStand.setCustomName(new ChatMessage(name));
        armorStand.setBasePlate(false);
        armorStand.setSmall(true);
        armorStand.setInvulnerable(true);
        armorStand.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(skull));

        //PacketPlayOutEntityEquipment EquipP = new PacketPlayOutEntityEquipment(armorStand.getId(), EnumItemSlot.HEAD.getSlotFlag(), CraftItemStack.asNMSCopy(skull));
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armorStand);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
        BukkitTask task = new BukkitRunnable() {
            double add = 0.1;
            @Override
            public void run() {

                armorStand.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());

                if (add >= (baseY+1))
                    add--;
                else if (add <= (baseY-1))
                    add++;
                else
                    add--;
            }
        }.runTaskTimer(ZombieMain.instance, 10, 0);
        return armorStand;
    }
}
