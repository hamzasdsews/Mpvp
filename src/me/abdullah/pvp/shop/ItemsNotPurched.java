package me.abdullah.pvp.shop;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.modes.AutoKit;
import me.abdullah.pvp.utils.ActionBarAPI;

public class ItemsNotPurched implements Listener{
	@EventHandler
	public void onItemsDonthave(InventoryClickEvent e) {
	Player p = (Player)e.getWhoClicked();
	ItemStack item = e.getCurrentItem();
	Location pLoc = p.getLocation();
		try
		{
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("PVP Shop"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Choose Feature"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Trails"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Available Trails"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("               &4&nSettings"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Who do you want to spectate?"))) {
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Available Battle Cry"))) {
				if (item.equals(VillagerDeath(p)))
				{
					p.sendMessage(Main.prefix + Main.color("&aListening to &eBattle Cry &8» &fVillager Death &aSound!"));
	                p.playSound(pLoc, Sound.VILLAGER_DEATH, 0.9f, 0.9f); 
					p.closeInventory();
				} else if (item.equals(ZombieDeath(p)))
				{
					p.sendMessage(Main.prefix + Main.color("&aListening to &eBattle Cry &8» &fZombie Death &aSound!"));
	                p.playSound(pLoc, Sound.ZOMBIE_DEATH, 0.9f, 0.9f); 
					p.closeInventory();
				} else if (item.equals(BatDeath(p)))
				{
					p.sendMessage(Main.prefix + Main.color("&aListening to &eBattle Cry &8» &fBat Death &aSound!"));
	                p.playSound(pLoc, Sound.BAT_DEATH, 100.0f, 100.0f); 
					p.closeInventory();
				} else if (item.equals(WolfDeath(p)))
				{
					p.sendMessage(Main.prefix + Main.color("&aListening to &eBattle Cry &8» &dCat Meow &aSound!"));
	                p.playSound(p.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
					p.closeInventory();
				} else if (item.equals(CatMeow(p)))
				{
					p.sendMessage(Main.prefix + Main.color("&aListening to &eBattle Cry &8» &fWolf Death &aSound!"));
	                p.playSound(p.getLocation(), Sound.WOLF_HOWL, 5.4f, 34.0f);
					p.closeInventory();
				} else {
					e.setCancelled(true);				
				}
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("&5You have an Trail."))) {
				e.setCancelled(true);	
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("&5You have an Battle Cry."))) {
				e.setCancelled(true);	
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Battle Cry"))) {
				e.setCancelled(true);	
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Perks"))) {
				e.setCancelled(true);	
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("Kits"))) {
				e.setCancelled(true);	
			}
		}
		catch (Exception locException) {
		}
	}
	public static ItemStack Heart(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Hearts"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this trail"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack Smoke(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Smoke"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this trail"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack LavaPoP(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("LavaPoP"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this trail"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack VillagerDeath(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Villager Death"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&a▶ Click to Listen!"));
		lore.add(Main.color("&c▶ You don't have this battle cry"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack ZombieDeath(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Zombie Death"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&a▶ Click to Listen!"));
		lore.add(Main.color("&c▶ You don't have this battle cry"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack BatDeath(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Bat Death"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&a▶ Click to Listen!"));
		lore.add(Main.color("&c▶ You don't have this battle cry"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack WolfDeath(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Wolf Death"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&a▶ Click to Listen!"));
		lore.add(Main.color("&c▶ You don't have this battle cry"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack CatMeow(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("Cat Meow"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&a▶ Click to Listen!"));
		lore.add(Main.color("&c▶ You don't have this battle cry"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack Fireworks(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("KillEffect ➸ Fireworks"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this KillEffect"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack Explosion(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("KillEffect ➸ Explosion"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this KillEffect"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack Strike(Player p) {
		ItemStack h = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("KillEffect ➸ Lightning Strike"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&c▶ You don't have this KillEffect"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setLore(lore);
		h.setItemMeta(meta);
		return h;
	}
	public static ItemStack Zynh(Player p) {
		ItemStack h = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)1);
		ItemMeta meta = h.getItemMeta();
		meta.setDisplayName(Main.color("&7"));
		h.setItemMeta(meta);
		return h;
	}
}
