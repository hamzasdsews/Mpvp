package me.abdullah.pvp.api;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public class NoAI {
    public static void setNoAI(org.bukkit.entity.Entity entity) {
        if (entity instanceof Player) {
            return;
        }
        NoAI.add(entity);
    }

    public static void removeNoAI(org.bukkit.entity.Entity entity) {
        if (entity instanceof Player) {
            return;
        }
        NoAI.remove(entity);
    }

    private static String ver() {
        String name = Bukkit.getServer().getClass().getPackage().getName();
        String version = name.substring(name.lastIndexOf(46) + 1);
        return version;
    }

    private static void remove(org.bukkit.entity.Entity e) {
        if (NoAI.ver().equalsIgnoreCase("v1_8_R3")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 0);
            nmsEntity.f(tag);
        } else if (NoAI.ver().equalsIgnoreCase("v1_8_R2")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 0);
            nmsEntity.f(tag);
        } else if (NoAI.ver().equalsIgnoreCase("v1_8_R1")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 0);
            nmsEntity.f(tag);
        } else {
            throw new IllegalArgumentException("Version: " + NoAI.ver() + " is not supported");
        }
    }

    private static void add(org.bukkit.entity.Entity e) {
        if (NoAI.ver().equalsIgnoreCase("v1_8_R3")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 1);
            nmsEntity.f(tag);
        } else if (NoAI.ver().equalsIgnoreCase("v1_8_R2")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 1);
            nmsEntity.f(tag);
        } else if (NoAI.ver().equalsIgnoreCase("v1_8_R1")) {
            Entity nmsEntity = ((CraftEntity)e).getHandle();
            NBTTagCompound tag = nmsEntity.getNBTTag();
            if (tag == null) {
                tag = new NBTTagCompound();
            }
            nmsEntity.c(tag);
            tag.setInt("NoAI", 1);
            nmsEntity.f(tag);
        } else {
            throw new IllegalArgumentException("Version: " + NoAI.ver() + " is not supported");
        }
    }
}

