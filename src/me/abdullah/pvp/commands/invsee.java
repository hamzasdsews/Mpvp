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
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.PlayerInventory
 */
package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class invsee
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (label.equalsIgnoreCase("invsee")) {
            if (p.hasPermission("ffa.invsee")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        String name = args[0];
                        if (Bukkit.getPlayer(name) == null) {
                            sender.sendMessage(Main.prefix + Main.F("&7The player is not &aOnline."));
                            return false;
                        }
                        Player t = Bukkit.getPlayer(name);
                        if (p == t) {
                            p.sendMessage(Main.prefix + Main.F("&7You can't see your inventory."));
                            return false;
                        }
                        p.openInventory(t.getInventory());
                        p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0f, 1.0f);
                        return false;
                    }
                    p.sendMessage(Main.prefix + Main.F("\u00a77Du musst ein Spieler sein"));
                } else {
                    p.hasPermission("staff.invsee");
                    p.sendMessage(Main.prefix + Main.F("&cSyntax: /invsee <player>"));
                }
            } else {
                p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
            }
        }
        return false;
    }
}

