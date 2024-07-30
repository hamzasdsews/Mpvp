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
 */
package me.abdullah.pvp.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.api.ItemsAPI;
import me.abdullah.pvp.modes.Settings;
import me.abdullah.pvp.modes.Spectator;
import me.abdullah.pvp.utils.SetSpawnUtil;

public class Staff
implements CommandExecutor, Listener {
    private static int i = 0;
	public ArrayList<String> v = new ArrayList<String>();

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("staff") && p.hasPermission("ffa.staff")) {
            if (this.v.contains(p.getName())) {
                this.v.remove(p.getName());
                for (Player All : Bukkit.getOnlinePlayers()) {
                    All.showPlayer(p);
                }
                SetSpawnUtil.teleport(p);
        		p.sendMessage(Main.prefix + "§bSpy mode has been §3Disabled.");
                p.performCommand("fly");
            	p.getInventory().setItem(4, Spectator.Spectator(p));
            	p.getInventory().setItem(7, Settings.Item(p));
            	p.getInventory().remove(ItemsAPI.Quit2());
            	p.getInventory().remove(new ItemStack(Material.DIAMOND_AXE));
                p.playSound(p.getLocation(), Sound.NOTE_PIANO, 0.1f, 0.1f);
                return true;
            }
            this.v.add(p.getName());
            for (Player All : Bukkit.getOnlinePlayers()) {
                All.hidePlayer(p);
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
            }
            p.performCommand("fly");
    		p.getInventory().setItem(0, ItemsAPI.Quit2());
    		p.sendMessage(Main.prefix + "§bSpy mode has been §3Enabled.");
        } else {
            p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
            p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);
        }
        return true;
    }
    @EventHandler
    public void onClickAtAxe(PlayerInteractEvent e) {
    	Player p = e.getPlayer();
    	
    	Action A = e.getAction();
    	if (A == Action.RIGHT_CLICK_BLOCK || A == Action.RIGHT_CLICK_AIR) {
    		if (p.getItemInHand().equals(ItemsAPI.Quit2())) {
            p.performCommand("fly");
        	p.getInventory().setItem(4, Spectator.Spectator(p));
        	p.getInventory().setItem(7, Settings.Item(p));
        	p.getInventory().remove(ItemsAPI.Quit2());
        	p.getInventory().remove(new ItemStack(Material.DIAMOND_AXE));
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 0.1f, 0.1f);
    		this.v.remove(p);
    	}
    	}
    }
}

