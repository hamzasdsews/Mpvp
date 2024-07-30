/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.event.player.PlayerLevelChangeEvent
 */
package me.abdullah.pvp.Listeners;

import java.text.DecimalFormat;
import java.util.Random;

import me.abdullah.pvp.holograms.RanksHologram;
import me.abdullah.pvp.holograms.ShopWarnHologram;
import me.abdullah.pvp.holograms.TopHologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.naarmc.mysql.mysql.LobbyStats;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.apiBars.ActionBarsAPI;
import me.abdullah.pvp.modes.AutoKit;
import me.abdullah.pvp.modes.Settings;
import me.abdullah.pvp.modes.Spectator;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.ranksup.RankAPI;
import me.abdullah.pvp.utils.ActionBarAPI;
import me.abdullah.pvp.utils.BoardAPI;
import me.abdullah.pvp.utils.PlayersSettings;
import me.abdullah.pvp.utils.SetSpawnUtil;
public class DeathEvent
implements Listener {

    @EventHandler
    public void onD(PlayerDeathEvent e) {
        e.setDroppedExp(0);
        e.getDrops().clear();
        e.setDeathMessage(null);
        
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        
        PVPStats.addKills(k, 1);
        PVPStats.addDeaths(p, 1);
        
// TODO: Random AddPoints
        
        Random ran = new Random();
        
        int Points = ran.nextInt(25) + 1;
		
        PVPStats.addPoints(k, Points);
        
        
        
        
// TODO: Random RemovePoints        
        Random ran1 = new Random();
        
        int Points1 = ran1.nextInt(10) - 1;
		
        PVPStats.removePoints(p, Points1);
        
        
        
        
//          TODO: MEOW        
        
        World world = p.getWorld();
        for (Player all : Bukkit.getOnlinePlayers())
        {
			BoardAPI.onScoreboard(p);
			BoardAPI.onScoreboard(all);
			BoardAPI.onScoreboard(k);
        }
        for (Player online : Bukkit.getOnlinePlayers()) {
            new TopHologram(new Location(Bukkit.getWorlds().get(0), -572,102,-2577), online);
        }
        ActionBarsAPI.PlayerDied(p);
        Damageable d = k;
        DecimalFormat df = new DecimalFormat("##.##");	
        String health = df.format(d.getHealth() / 2.0D);

// TODO: Checker XP ks amk!
        
        
        LobbyStats.CheckerXP(p);
        
        LobbyStats.CheckerXP(k);
        
        
        p.sendMessage(Main.prefix + Main.F("§cYour enemy " + k.getDisplayName() + " §cstill had §e" + health + " ❤."));
        p.sendMessage(Main.prefix + "-" + Points1 + " §cPoints");      
        
        k.sendMessage(Main.prefix + Main.F("§aYou killed " + p.getDisplayName() + " §awith §e" + health + " ❤."));
        k.sendMessage(Main.prefix + "+" + Points + " §aPoints");
        k.sendMessage(Main.prefix + "§a✚1 Arrow §8┃ §6✚1 Flint Fire");

        k.setHealth(20.0);
        p.setLevel(0);
        k.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        k.setLevel(k.getLevel() + 1);
        
        
        BoardAPI.onScoreboard(p);
        BoardAPI.onScoreboard(k);
        
        AutoKit.Enabled(p);
        
		PlayerInventory pInv = p.getInventory();
		ItemStack[] arrayOfItemStack;
        for (int j = (arrayOfItemStack = k.getPlayer().getInventory().getContents()).length, i = 0; i < j; ++i) {
            final ItemStack item = arrayOfItemStack[i];
            if (item instanceof ItemStack && item.getType() instanceof Material && item.getType() == Material.FLINT_AND_STEEL) {
                item.setDurability((short)(item.getDurability() - 1));
            }
        }

    }





    @EventHandler
    public void onKill(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();
        if (p.getLevel() == 5) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l5&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 10) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l10&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 15) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l15&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 20) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l20&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 25) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l25&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 30) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l30&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 35) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l35&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 40) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l40&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 45) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l45&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 50) {
        	Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l50&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 55) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l55&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 60) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l60&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 65) {
        	Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l65&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 70) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l70&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 75) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l75&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 80) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l80&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 85) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l85&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 90) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l90&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 95) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l95&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        if (p.getLevel() == 100) {
            Bukkit.broadcastMessage(Main.prefix + Main.color("§3Player " + RankAPI.getPlayerName(p) + " &3is on killstreak of &6&l100&3."));
        	p.getInventory().addItem(new ItemStack(Material.TNT, 1));
    		p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
        }
    }
