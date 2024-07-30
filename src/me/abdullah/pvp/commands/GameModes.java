/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class GameModes
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (sender.hasPermission("ffa.gamemodes")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fSurvival"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fCreative"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fAdventure"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fSpectator"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                
                
                if (args[0].equalsIgnoreCase("s")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fSurvival"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("c")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fCreative"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("a")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fAdventure"));
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
                if (args[0].equalsIgnoreCase("spectator")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Main.prefix + Main.F("&3Your game mode has been updated to &fSpectator"));                   
                    p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
                }
            } else {
               p.sendMessage(Main.prefix + Main.F("&7&m-----------------------"));
               p.sendMessage(Main.prefix + Main.F("&cError Usage: &c/gm &8[&a0,1,2,3&8]&7."));
               p.sendMessage(Main.prefix + Main.F("&3Or Usage ➷"));
               p.sendMessage(Main.prefix + Main.F("&cError Usage: &c/gamemode &8[&aS,C,A,Spectator&8]&7."));
               p.sendMessage(Main.prefix + Main.F("&7&m-----------------------"));
               p.playSound(p.getLocation(), Sound.valueOf("LEVEL_UP"), 10, 10);
            }
        } else {
        	p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
            p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
            return false;
        }
        return false;
    }
}

