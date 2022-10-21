package fr.lightnew.tools;

import com.mojang.datafixers.util.Pair;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HeadClick {

    public static EntityArmorStand createHeadClick(Player player, String name, ItemStack skull) {
        //NE SPAWN PAS
        WorldServer s = ((CraftWorld)player.getWorld()).getHandle();
        EntityArmorStand armorStand = new EntityArmorStand(EntityTypes.ARMOR_STAND, s);

        armorStand.setCustomName(new ChatMessage(name));
        armorStand.setCustomNameVisible(true);
        armorStand.setInvulnerable(true);
        armorStand.setInvisible(true);
        armorStand.setSmall(true);
        armorStand.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

        List<Pair<EnumItemSlot, net.minecraft.server.v1_16_R3.ItemStack>> list = new ArrayList<>();
        list.add(new Pair<>(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(skull)));

        PacketPlayOutEntityEquipment EquipP = new PacketPlayOutEntityEquipment(armorStand.getId(), list);
        PacketPlayOutEntityMetadata standMeta = new PacketPlayOutEntityMetadata(armorStand.getId(), armorStand.getDataWatcher(), true);
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armorStand);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(EquipP);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(standMeta);
        return armorStand;
    }
}
