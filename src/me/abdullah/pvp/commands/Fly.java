/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class Fly
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
       if (cmd.getName().equalsIgnoreCase("fly"));
        Player p = (Player)sender;
        
        
        
        if (!p.hasPermission("ffa.fly")) {
        	p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
            p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
            return true;
        }
        if (args.length == 0 && (p.hasPermission("ffa.fly"))) {
        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage(Main.prefix + Main.F("&bset fly mode &cDisabled &bfor &bYou!."));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.3f, 0.3f);
        } else {
            p.setAllowFlight(true);
            p.sendMessage(Main.prefix + Main.F("&bset fly mode &aEnabled &bfor &bYou!."));
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
        }
        }
        
        
        if (args.length == 1 && (p.hasPermission("ffa.fly"))) {
        Player target = Bukkit.getPlayer(args[0]);
        if (target.getAllowFlight()) {
            target.setAllowFlight(false);
            target.setFlying(false);
            target.sendMessage(Main.prefix + Main.F("&bset fly mode &cDisabled &bfor &bYou by &d"+ p.getName()));
            target.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.3f, 0.3f);
        } else {
        	target.setAllowFlight(true);
        	target.sendMessage(Main.prefix + Main.F("&bset fly mode &aEnabled &bfor &bYou by &d" + p.getName()));
        	target.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
        }
        
        
        
        return true;
}
		return true;
}
}

