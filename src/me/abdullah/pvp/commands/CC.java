/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.commands;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.ranksup.RankAPI;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CC
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("cc") && p.hasPermission("ffa.clearchat")) {
            for (int i = 0; i < 100; ++i) {
                Bukkit.broadcastMessage((String)"");
            }
            Bukkit.broadcastMessage(Main.prefix + Main.F("&a&lThe chat was cleaned by " + RankAPI.getPlayerName(p)));
        } else {
            p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
            p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
        }
        return false;
    }
}

