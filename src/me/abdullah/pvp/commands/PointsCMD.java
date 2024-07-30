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
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.BoardAPI;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PointsCMD
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("addpoints")) {
            if (p.hasPermission("pvp.addpoints")) {
                if (args.length == 0) {
                    p.sendMessage(Main.prefix + Main.F("&aUsage: /addpoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    p.sendMessage(Main.prefix + Main.F("&aUsage: /addpoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                if (args.length == 1) {
                    p.sendMessage(Main.prefix + Main.F("&aUsage: /addpoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                if (args[1].equalsIgnoreCase("1")) {
                    PVPStats.setPoints(target, 1);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 1 Point for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("5")) {
                    PVPStats.addPoints(target, 5);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 5 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("10")) {
                    PVPStats.addPoints(target, 10);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 10 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("50")) {
                    PVPStats.addPoints(target, 50);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 50 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("100")) {
                    PVPStats.addPoints(target, 100);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 100 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("500")) {
                    PVPStats.addPoints(target, 500);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 500 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("1000")) {
                    PVPStats.addPoints(target, 1000);
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&aDone Add 1000 Points for you by &e" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
            } else {
                p.sendMessage(Main.prefix + Main.F("&cYou do not have Permission"));
            }
        }
        if (cmd.getName().equalsIgnoreCase("removepoints")) {
            if (p.hasPermission("pvp.removepoints")) {
                if (args.length == 0) {
                    p.sendMessage(Main.prefix + Main.F("&cUsage: /removepoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    p.sendMessage(Main.prefix + Main.F("&cUsage: /removepoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                if (args.length == 1) {
                    p.sendMessage(Main.prefix + Main.F("&cUsage: /removepoints <Player> 1/5/10/50/100/500/1000"));
                    return true;
                }
                if (args[1].equalsIgnoreCase("1")) {
                    PVPStats.removePoints(target, 1);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 5 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("5")) {
                    PVPStats.removePoints(target, 5);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 5 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("10")) {
                    PVPStats.removePoints(target, 10);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 10 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("50")) {
                    PVPStats.removePoints(target, 50);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 50 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("100")) {
                    PVPStats.removePoints(target, 100);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 100 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("500")) {
                    PVPStats.removePoints(target, 500);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 500 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
                if (args[1].equalsIgnoreCase("1000")) {
                    PVPStats.removePoints(target, 1000);
                    p.playSound(p.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    p.sendMessage(Main.prefix + Main.F("&cDone Removing 1000 Points for you by &b" + p.getName()));
                    BoardAPI.onScoreboard(p);
                }
            } else {
                p.sendMessage(Main.prefix + Main.F("&cYou do not have Permission"));
            }
        }
		return true;
    }
}
