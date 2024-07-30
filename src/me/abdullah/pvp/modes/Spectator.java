
package me.abdullah.pvp.modes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.naarmc.mysql.api.TabAPI;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.api.ItemsAPI;
import me.abdullah.pvp.apiBars.ActionBarsAPI;
import me.abdullah.pvp.ranksup.RankAPI;
import me.abdullah.pvp.utils.ActionBarAPI;
import me.abdullah.pvp.utils.BoardAPI;
import me.abdullah.pvp.utils.EntityUtils;
import me.abdullah.pvp.utils.KitAPI;
import me.abdullah.pvp.utils.PlayerUtil;
import me.abdullah.pvp.utils.SetSpawnUtil;
public class Spectator implements Listener{
	public static ItemStack Spectator(Player p) {
		ItemStack spec = new ItemStack(Material.FEATHER);
		ItemMeta meta = spec.getItemMeta();
		meta.setDisplayName(Main.color("&6&lSpectate"));
        spec.setItemMeta(meta);
		return spec;
	}
	@EventHandler
	public void onClickSpectator(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        PlayerInventory pInv = p.getInventory();
        ItemStack Hand = p.getItemInHand();
        Location pLoc = p.getLocation();
        World world = p.getWorld();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && Hand.equals(Spectator(p)) && p.hasPermission("pvp.spectate")) {            
//            p.playSound(pLoc, Sound.BAT_LOOP, 100.0f, 100.0f);
//            	e.setCancelled(true);
//            	Main.spectate.add(p);
//            	Main.HaveKit.add(p);
//        		if (world.getName().equalsIgnoreCase("PVP"))
//        		{
//        			SetSpawnUtil.TPDesertWorld(p);
//        		}
//        		if (world.getName().equalsIgnoreCase("PVP2"))
//        		{
//        			SetSpawnUtil.TPRoseWorld(p);			
//        		}
//        		if (world.getName().equalsIgnoreCase("PVP3"))
//        		{
//        			SetSpawnUtil.TPCFWorld(p);			
//        		}
//        		for (Player all : Bukkit.getOnlinePlayers())
//        		{
//        			TabAPI.UpdateTablist(all);
//        			TabAPI.UpdateTablist(p);
//        		}
//            	pInv.clear();
//                Main.NoKit.remove(p);
//            	ActionBarsAPI.SpectateON(p);
//            	pInv.setArmorContents(null);
//        		pInv.setItem(0, ItemsAPI.Quit());
//            	p.setAllowFlight(true);
//            	p.setFlying(true);
//            	BoardAPI.onScoreboard(p);
//                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 0));
//            	if (Main.spectate.contains(p.getName())) {
//            		for (Player a : Bukkit.getOnlinePlayers()) {
//            			a.hidePlayer(p);
//            		}
//            		} else{
            			p.setItemInHand(null);
            			p.sendMessage(Main.prefix + Main.color("&eWe are sorry, the spectate is comming soon."));
            		}
            	}
    	@EventHandler
    	public void onClickLeaveSpectate(PlayerInteractEvent e) {
            Player p = e.getPlayer();
            Action action = e.getAction();
            PlayerInventory pInv = p.getInventory();
            ItemStack Hand = p.getItemInHand();
            Location pLoc = p.getLocation();
            World world = p.getWorld();
            if ((action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && Hand.equals(ItemsAPI.Quit()) && p.hasPermission("pvp.spectate")) {
//            	Main.spectate.remove(p.getName());
//            	Main.HaveKit.remove(p);
//        		if (world.getName().equalsIgnoreCase("PVP"))
//        		{
//        			SetSpawnUtil.TPDesertWorld(p);
//        		}
//        		if (world.getName().equalsIgnoreCase("PVP2"))
//        		{
//        			SetSpawnUtil.TPRoseWorld(p);			
//        		}
//        		if (world.getName().equalsIgnoreCase("PVP3"))
//        		{
//        			SetSpawnUtil.TPCFWorld(p);			
//        		}  
//        		ActionBarsAPI.SpectateOFF(p);
//            	pInv.setArmorContents(null);
//            	pInv.remove(Material.SLIME_BALL);
//            	pInv.remove(Material.COMPASS);
//            	pInv.remove(Material.FEATHER);
//            	pInv.setItem(1, KitsSelector.Selector());
//            	pInv.setItem(4, Spectator.Spectator(p));
//            	pInv.setItem(7, Settings.Item(p));
//                p.playSound(pLoc, Sound.NOTE_PIANO, 100.0f, 100.0f);
//            	p.setAllowFlight(false);
//            	p.setFlying(false);
//                Main.NoKit.add(p);
//            	BoardAPI.onScoreboard(p);
//                p.removePotionEffect(PotionEffectType.INVISIBILITY);
//        		for (Player all : Bukkit.getOnlinePlayers())
//        		{
//        			TabAPI.UpdateTablist(all);
//        			TabAPI.UpdateTablist(p);
//        		}
//            	if (!Main.spectate.contains(p.getName())) {
//            		for (Player a2 : Bukkit.getOnlinePlayers()) {
//            			a2.showPlayer(p);
//            		}
//            		} else if (!p.hasPermission("pvp.spectate")) {
            			p.setItemInHand(null);
            			p.sendMessage(Main.prefix + Main.color("&eWe are sorry, the spectate is comming soon."));
            		}
            	}
            }
	      
