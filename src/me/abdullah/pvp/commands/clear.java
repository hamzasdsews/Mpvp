/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.PlayerInventory
 */
package me.abdullah.pvp.commands;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.ranksup.RankAPI;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clear
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        
        
        if (args.length == 0 && (p.hasPermission("ffa.clear"))) {
        p.sendMessage(Main.prefix + Main.F("&3Cleaned the Inventory of &e&lYou."));
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.playSound(p.getLocation(), Sound.ITEM_BREAK, 0.9f, 0.9f);
        
    	}
        
        else if (args.length == 1 && (p.hasPermission("ffa.clear"))) {
            Player target = Bukkit.getPlayer(args[0]);
            target.sendMessage(Main.prefix + Main.F("&3Cleaned the Inventory of you by " + RankAPI.getPlayerName(p)));
            target.getInventory().clear();
            target.getInventory().setArmorContents(null);   
            target.playSound(p.getLocation(), Sound.ITEM_BREAK, 0.9f, 0.9f);
        } else {
        	p.sendMessage((Object)Main.prefix + Main.F("&cYou don't have permissions"));
            p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
        }
     
        
        
		return false; 
    	}
}