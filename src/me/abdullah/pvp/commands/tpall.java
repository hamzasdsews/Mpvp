/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class tpall
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("ffa.tpall")) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(p);
                        all.sendMessage(Main.prefix + Main.F("&eTeleporting all players to &a" + p.getName()));
                }
            } else {
                p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
            }
        }
        return false;
    }
}

