/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.entity.Skeleton$SkeletonType
 *  org.bukkit.inventory.ItemStack
 */
package me.abdullah.pvp.commands;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.api.NoAI;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;

public class Custom
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("custom")) {
            if (p.hasPermission("ffa.setup")) {
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(Main.prefix) + "\u00a7cSyntax: /custom [shop]");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("shop") && p.hasPermission("ffa.setup")) {
                        Skeleton skeleton = (Skeleton)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);
                        skeleton.setSkeletonType(Skeleton.SkeletonType.WITHER);
                        skeleton.setCustomName(Main.F("§bShop"));
                        skeleton.setCustomNameVisible(true);
                        net.minecraft.server.v1_8_R3.Entity znms = ((CraftEntity)skeleton).getHandle();
                        NBTTagCompound ztag = new NBTTagCompound();
                        znms.c(ztag);
                        ztag.setBoolean("Silent", true);
                        znms.f(ztag);
                        NoAI.setNoAI((Entity)skeleton);
                    }
                        return false;
                    }
                }
                return false;
            }
            return false;
    }
}

