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
import org.bukkit.scheduler.BukkitRunnable;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.utils.PlayersSettings;
public class Settings implements Listener{

	
	
	public static Inventory SettingsGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, Main.color("               &4&nSettings"));
		inv.setItem(3, Time(p));
		inv.setItem(5, Scramble(p));
		p.openInventory(inv);
		return inv;
	}
	@EventHandler
	public void onClickSettings(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        PlayerInventory pInv = p.getInventory();
        Location pLoc = p.getLocation();
		Inventory inventory = e.getInventory();
		String inventoryName = ChatColor.translateAlternateColorCodes('&', inventory.getName());
		if (inventoryName.equalsIgnoreCase(Main.color("               &4&nSettings"))) {
			ItemStack currentItem = e.getCurrentItem();
			if (currentItem == null || currentItem.getType() == Material.AIR)
				return;
			String itemName = "None";
			if (currentItem.hasItemMeta()) {
				itemName = ChatColor.translateAlternateColorCodes('&', currentItem.getItemMeta().getDisplayName());
				
				
	    // Time
		if (itemName.equalsIgnoreCase(Main.color("&a&lTime &8▶ &cNight"))) {
			PlayersSettings.setTime(p.getPlayer().getName(), 1);
			p.sendMessage(Main.prefix + Main.color("&cGood Night!"));
			p.setPlayerTime(13000, false);
			p.playSound(pLoc, Sound.ZOMBIE_IDLE, 0.9f, 0.9f);
			p.closeInventory();
			e.setCancelled(true);
		}
		if (itemName.equalsIgnoreCase(Main.color("&a&lTime &8▶ &aDay"))) {
			PlayersSettings.setTime(p.getPlayer().getName(), 0);
			p.sendMessage(Main.prefix + Main.color("&aGood Morning."));
			p.setPlayerTime(1000, false);
			p.playSound(pLoc, Sound.CHICKEN_HURT, 0.9f, 0.9f);
			p.closeInventory();
			e.setCancelled(true);
		}
		
		// Scramble
		if (itemName.equalsIgnoreCase(Main.color("&6&lScramble &8▶ &cOff"))) {
            PlayersSettings.setscramble(p.getPlayer().getName(), 1);
			p.sendMessage(Main.prefix + Main.color("&cYour rank has been hidden"));
			p.playSound(pLoc, Sound.ANVIL_USE, 100.0f, 100.0f);
			p.closeInventory();
			e.setCancelled(true);
		}
		if (itemName.equalsIgnoreCase(Main.color("&6&lScramble &8▶ &aOn"))) {
            PlayersSettings.setscramble(p.getPlayer().getName(), 0);
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
			p.closeInventory();
			e.setCancelled(true);
			p.sendMessage(Main.prefix + Main.color("&aYour rank has been shown"));
		}
       }
	  }
     }
	public static ItemStack Time(Player p) {
        if (PlayersSettings.getTime(p.getName()) == 1) 
        {
			ItemStack day = new ItemStack(Material.WATCH);
			ItemMeta meta = day.getItemMeta();
			meta.setDisplayName(Main.color("&a&lTime &8▶ &aDay"));
			ArrayList lore = new ArrayList<>();
			lore.add("");
			lore.add("§a➟ Click to change your time to Day!");
			meta.setLore(lore);
			day.setItemMeta(meta);
			return day;	
		} else {
			ItemStack night = new ItemStack(Material.WATCH);
			ItemMeta meta = night.getItemMeta();
			meta.setDisplayName(Main.color("&a&lTime &8▶ &cNight"));
			ArrayList lore = new ArrayList<>();
			lore.add("");
			lore.add("§a➟ Click to change your time to Night!");
			meta.setLore(lore);
			night.setItemMeta(meta);
			return night;
		}
	}
	public static ItemStack Scramble(Player p) {
        if (PlayersSettings.getscramble(p.getName()) == 1) 
        {
			ItemStack SOn = new ItemStack(Material.GOLDEN_APPLE, 1,(short)1);
			ItemMeta meta = SOn.getItemMeta();
			meta.setDisplayName(Main.color("&6&lScramble &8▶ &aOn"));
			ArrayList lore = new ArrayList<>();
			lore.add("");
			lore.add("§a➟ Click to §eunhide §ayour rank!");
			meta.setLore(lore);
			SOn.setItemMeta(meta);
			return SOn;
        }else {
			ItemStack SO = new ItemStack(Material.GOLDEN_APPLE);
			ItemMeta meta1 = SO.getItemMeta();
			meta1.setDisplayName(Main.color("&6&lScramble &8▶ &cOff"));
			ArrayList lore1 = new ArrayList<>();
			lore1.add("");
			lore1.add("§a➟ Click to §chide §ayour rank!");
			meta1.setLore(lore1);
			SO.setItemMeta(meta1);
			return SO;
	     }
		}
	@EventHandler
	public void onClickSpectator(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack Hand = p.getItemInHand();
        Action action = e.getAction();
        Location pLoc = p.getLocation();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && Hand.equals(Item(p))) {
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            p.openInventory(SettingsGUI(p));
        }
	}
	public static ItemStack Item(Player p) {
		ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.color("&c&lSettings"));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack OutItem(Player p) {
		ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Main.color("&e&l&e&lSettings"));
		item.setItemMeta(meta);
		return item;
	}
}
