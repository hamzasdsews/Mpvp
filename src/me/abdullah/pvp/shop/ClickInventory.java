/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.abdullah.pvp.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.modes.Flint;
import me.abdullah.pvp.modes.Settings;
import me.abdullah.pvp.modes.Spectator;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.ActionBarAPI;
import me.abdullah.pvp.utils.EntityUtils;
import me.abdullah.pvp.utils.PlayersShop;

public class ClickInventory
implements Listener {
	@EventHandler
	public void onClickKits(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        PlayerInventory pInv = p.getInventory();
        Location pLoc = p.getLocation();
		Inventory inventory = e.getInventory();
		String inventoryName = ChatColor.translateAlternateColorCodes('&', inventory.getName());
		if (inventoryName.equalsIgnoreCase("Kits")) {
			ItemStack currentItem = e.getCurrentItem();
			if (currentItem == null || currentItem.getType() == Material.AIR)
				return;
			String itemName = "None";
			if (currentItem.hasItemMeta()) {
				itemName = ChatColor.translateAlternateColorCodes('&', currentItem.getItemMeta().getDisplayName());
        if (itemName.equalsIgnoreCase(Main.color("&6&lGold Kit"))) {
            if (PVPStats.getPoints(p.getName()) >= 1300 && p.hasPermission("ffa.goldkit")) {
				if (!p.hasPermission("ffa.goldkit")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + " ffa.goldkit");
				}
	            ItemStack sword2 = new ItemStack(Material.STONE_SWORD);
	            ItemMeta meta = sword2.getItemMeta();
	            meta.setDisplayName(Main.color("&eSword"));
	            meta.spigot().setUnbreakable(true);
	            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            sword2.setItemMeta(meta);
	            sword2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	            ItemStack bow2 = new ItemStack(Material.BOW);
	            ItemMeta bowmeta = bow2.getItemMeta();
	            bowmeta.setDisplayName(Main.color("&eBow"));
	            bowmeta.spigot().setUnbreakable(true);
	            bowmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            bow2.setItemMeta(bowmeta);
	            bow2.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
	            ItemStack arrow = new ItemStack(Material.ARROW, 10);
	            ItemMeta arrowmeta2 = arrow.getItemMeta();
	            arrowmeta2.setDisplayName(Main.color("&eArrow"));
	            arrowmeta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            arrow.setItemMeta(arrowmeta2);
	            ItemStack helmet2 = new ItemStack(Material.IRON_HELMET);
	            ItemMeta helmetmeta2 = helmet2.getItemMeta();
	            helmetmeta2.setDisplayName(Main.color("&eHelmet"));
	            helmetmeta2.spigot().setUnbreakable(true);
	            helmetmeta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            helmet2.setItemMeta(helmetmeta2);
	            helmet2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
	            ItemMeta chestplatemeta = chestplate.getItemMeta();
	            chestplatemeta.setDisplayName(Main.color("&eChestplate"));
	            chestplatemeta.spigot().setUnbreakable(true);
	            chestplatemeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            chestplate.setItemMeta(chestplatemeta);
	            chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
	            ItemMeta leggingsmeta = chestplate.getItemMeta();
	            leggingsmeta.setDisplayName(Main.color("&eLeggings"));
	            leggingsmeta.spigot().setUnbreakable(true);
	            leggingsmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            leggings.setItemMeta(leggingsmeta);
	            leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack Boot2 = new ItemStack(Material.IRON_BOOTS);
	            ItemMeta Bootmeta2 = Boot2.getItemMeta();
	            Bootmeta2.setDisplayName(Main.color("&eBoot"));
	            Bootmeta2.spigot().setUnbreakable(true);
	            Bootmeta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            Boot2.setItemMeta(Bootmeta2);
	            Boot2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack Rod2 = new ItemStack(Material.FISHING_ROD);
	            ItemMeta Rodmeta = Rod2.getItemMeta();
	            Rodmeta.setDisplayName(Main.color("&eRod"));
	            Rodmeta.spigot().setUnbreakable(true);
	            Rodmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            Rod2.setItemMeta(Rodmeta);
	            pInv.setItem(0, sword2);
	            pInv.setItem(1, Rod2);
	            pInv.setItem(2, bow2);
				pInv.remove(new ItemStack(Material.FEATHER));
	            pInv.setItem(7, Flint.Flint(p));		        	            
	            pInv.setItem(8, arrow);
	            pInv.setHelmet(helmet2);
	            pInv.setChestplate(chestplate);
	            pInv.setLeggings(leggings);
	            pInv.setBoots(Boot2);
		        pInv.remove(Material.WATCH);
		        pInv.remove(Material.NETHER_STAR);
		        pInv.remove(Material.REDSTONE_COMPARATOR);
                p.sendMessage(Main.prefix + Main.color("&aEnjoy for your kit."));
                p.closeInventory();
            } else {
                if (PVPStats.getPoints(p.getName()) <= 1300) {
                p.sendMessage(Main.prefix + Main.color("&aYou don't have 1300 &ePoints to open this kit."));
                p.playSound(pLoc, Sound.NOTE_PIANO, 100f, 100f);
                e.setCancelled(true);
            }
          }
        }
        if (itemName.equalsIgnoreCase(Main.color("&b&lDiamond Kit"))) {
            if (PVPStats.getPoints(p.getName()) >= 2600 && p.hasPermission("ffa.diamondkit")) {
            	if (!p.hasPermission("ffa.diamondkit")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + " ffa.diamondkit");
				}
	            ItemStack sword2 = new ItemStack(Material.IRON_SWORD);
	            ItemMeta meta = sword2.getItemMeta();
	            meta.setDisplayName(Main.color("&e&lSword"));
	            meta.spigot().setUnbreakable(true);
	            sword2.setItemMeta(meta);
	            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            sword2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	            ItemStack bow2 = new ItemStack(Material.BOW);
	            ItemMeta bowmeta = bow2.getItemMeta();
	            bowmeta.setDisplayName(Main.color("&e&lBow"));
	            bowmeta.spigot().setUnbreakable(true);
	            bow2.setItemMeta(bowmeta);
	            bowmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            bow2.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
	            ItemStack arrow = new ItemStack(Material.ARROW, 15);
	            ItemMeta arrowmeta2 = arrow.getItemMeta();
	            arrowmeta2.setDisplayName(Main.color("&e&lArrow"));
	            arrow.setItemMeta(arrowmeta2);
	            ItemStack helmet2 = new ItemStack(Material.IRON_HELMET);
	            ItemMeta helmetmeta2 = helmet2.getItemMeta();
	            helmetmeta2.setDisplayName(Main.color("&e&lHelmet"));
	            helmetmeta2.spigot().setUnbreakable(true);
	            helmetmeta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            helmet2.setItemMeta(helmetmeta2);
	            helmet2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
	            ItemMeta chestplatemeta = chestplate.getItemMeta();
	            chestplatemeta.setDisplayName(Main.color("&e&lChestplate"));
	            chestplatemeta.spigot().setUnbreakable(true);
	            chestplatemeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            chestplate.setItemMeta(chestplatemeta);
	            chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	            ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
	            ItemMeta leggingsmeta = chestplate.getItemMeta();
	            leggingsmeta.setDisplayName(Main.color("&e&lLeggings"));
	            leggingsmeta.spigot().setUnbreakable(true);
	            leggingsmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            leggings.setItemMeta(leggingsmeta);
	            leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	            ItemStack Boot2 = new ItemStack(Material.IRON_BOOTS);
	            ItemMeta Bootmeta2 = Boot2.getItemMeta();
	            Bootmeta2.setDisplayName(Main.color("&e&lBoot"));
	            Bootmeta2.spigot().setUnbreakable(true);
	            Bootmeta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            Boot2.setItemMeta(Bootmeta2);
	            Boot2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            ItemStack Rod2 = new ItemStack(Material.FISHING_ROD);
	            ItemMeta Rodmeta = Rod2.getItemMeta();
	            Rodmeta.setDisplayName(Main.color("&e&lRod"));
	            Rodmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	            Rodmeta.spigot().setUnbreakable(true);
	            Rod2.setItemMeta(Rodmeta);
	            pInv.setItem(0, sword2);
	            pInv.setItem(1, Rod2);
	            pInv.setItem(2, bow2);
				pInv.remove(new ItemStack(Material.FEATHER));
	            pInv.setItem(7, Flint.Flint(p));		        	            
	            pInv.setItem(8, arrow);
	            pInv.setHelmet(helmet2);
	            pInv.setChestplate(chestplate);
	            pInv.setLeggings(leggings);
	            pInv.setBoots(Boot2);
                p.closeInventory();
                p.sendMessage(Main.prefix + Main.color("&aEnjoy for your kit."));
		        pInv.remove(Material.WATCH);
		        pInv.remove(Material.NETHER_STAR);
		        pInv.remove(Material.REDSTONE_COMPARATOR);
				p.closeInventory();
            } else {
            if (PVPStats.getPoints(p.getName()) <= 2600) {
                e.setCancelled(true);
                p.sendMessage(Main.prefix + Main.color("&aYou don't have 2600 &ePoints to open this kit."));
                p.playSound(pLoc, Sound.NOTE_PIANO, 100f, 100f);
                }
            }
        }
	}
   }}
	@EventHandler
	public void onClickFeatures(InventoryClickEvent e)
	{
        Player p = (Player)e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        PlayerInventory pInv = p.getInventory();
        Location pLoc = p.getLocation();
		Inventory inventory = e.getInventory();
		String inventoryName = ChatColor.translateAlternateColorCodes('&', inventory.getName());
		if (inventoryName.equalsIgnoreCase("Choose Feature")) {
			}
			if (i.equals(ShopBattleCry.BattleCryOpenFeature()))
			{
	            if (PlayersShop.getVillagerdeath(p) == 2) {
	            	p.openInventory(Main.haveVillagerDeath(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getZombiedeath(p) == 2) {
	            	p.openInventory(Main.haveZombieDeath(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getBatdeath(p) == 2) {
	            	p.openInventory(Main.haveBatDeath(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getWolfdeath(p) == 2) {
	            	p.openInventory(Main.haveWolfDeath(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getCatMeowdeath(p) == 2) {
	            	p.openInventory(Main.haveCatMeow(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getFirework(p) == 2) {
	            	p.openInventory(Main.haveFirework(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else if (PlayersShop.getStrike(p) == 2) {
	            	p.openInventory(Main.haveStrike(p));
	            	p.playSound(pLoc, Sound.LEVEL_UP, 100.0f, 100.0f);
	            } else {
					p.openInventory(Main.BattleCryFeature(p));
					p.playSound(pLoc, Sound.SLIME_WALK2, 100.0f, 100.0f);
	            }
			}
			if (i.equals(ShopTrails.TrailsFeatures()))
			{
	            p.openInventory(Main.TrailsFeature(p));
                p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
	            if (PlayersShop.getHeart(p) == 2) {
	            	p.openInventory(Main.haveHeart(p));
	                p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
	            }
	            if (PlayersShop.getSmoke(p) == 2) {
	            	p.openInventory(Main.haveSmoke(p));
	                p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
	            }
	            if (PlayersShop.getLava(p) == 2) {
	            	p.openInventory(Main.haveLavaPoP(p));
	                p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
	            }
	            e.setCancelled(true);
	        }
		}
	@EventHandler
	public void onClickAtItemsPlaying(InventoryClickEvent e)
	{
        Player p = (Player)e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        PlayerInventory pInv = p.getInventory();
        Location pLoc = p.getLocation();
		PlayerInventory inventory = p.getInventory();
		if (item.equals(Spectator.Spectator(p)))
		{
			e.setCancelled(true);
		}
		if (item.equals(Settings.Item(p)))
		{
			e.setCancelled(true);
		}
	}
    @EventHandler
    public void onClickShop(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        PlayerInventory pInv = p.getInventory();
        Location pLoc = p.getLocation();
		Inventory inventory = e.getInventory();
		String inventoryName = ChatColor.translateAlternateColorCodes('&', inventory.getName());
		if (inventoryName.equalsIgnoreCase("PVP Shop")) {
			ItemStack currentItem = e.getCurrentItem();
			if (currentItem == null || currentItem.getType() == Material.AIR)
				return;
			String itemName = "None";
			if (currentItem.hasItemMeta()) {
				itemName = ChatColor.translateAlternateColorCodes('&', currentItem.getItemMeta().getDisplayName());
	    if (itemName.equalsIgnoreCase(Main.color("&e&l&e&lSettings")))
	    {
	    	p.openInventory(Settings.SettingsGUI(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            e.setCancelled(true);
	    }
        if (itemName.equalsIgnoreCase(Main.color("&3&lKits"))) {
            p.openInventory(Main.Kits(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (itemName.equalsIgnoreCase(Main.color("&6&lTrails"))) {
            p.openInventory(Main.Trails(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (itemName.equalsIgnoreCase(Main.color("&a&lPerks"))) {
            p.openInventory(Main.Perks(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (itemName.equalsIgnoreCase(Main.color("&e&lBattle Cry"))) {
            p.openInventory(Main.BattleCry(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
            e.setCancelled(true);
        }        
//        if (itemName.equalsIgnoreCase(Main.color("&a&lOne-time Purchase"))) {
//            p.openInventory(Main.OnetimePurchase(p));
//            p.playSound(pLoc, Sound.CLICK, 1.0f, 1.0f);
//            e.setCancelled(true);
//        }
        if (itemName.equalsIgnoreCase(Main.color("&b&lFeatures"))) {
            p.openInventory(Main.PurchedItems(p));
            p.playSound(pLoc, Sound.CLICK, 5.4f, 34.0f);
        }
	}
}
        if (item.equals(ShopBattleCry.RemoveBattleCry(p))) {
        	PlayersShop.setVillagerdeath(p, 1);
        	PlayersShop.setZombiedeath(p, 1);
        	PlayersShop.setBatdeath(p, 1);
        	PlayersShop.setWolfdeath(p, 1);
        	PlayersShop.setCatMeowdeath(p, 1);
        	PlayersShop.setFirework(p, 1);
        	PlayersShop.setStrike(p, 1);
        	p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            ActionBarAPI.sendActionBar(p, "&6✸ &aNow you can use a Feature &6❤");
            p.openInventory(Main.BattleCryFeature(p));
            e.setCancelled(true);
        }
        if (item.equals(ShopTrails.RemoveTrail(p))) {
//            Bukkit.getServer().getScheduler().cancelTask(ArrowTrails.heart);
//            Bukkit.getServer().getScheduler().cancelTask(ArrowTrails.smoke);
//            Bukkit.getServer().getScheduler().cancelTask(ArrowTrails.lavapop);
        	PlayersShop.setHeart(p, 1);
        	PlayersShop.setSmoke(p, 1);
        	PlayersShop.setLava(p, 1);
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            ActionBarAPI.sendActionBar(p, "&6✸ &aNow you can use a Feature. &6❤");
            p.openInventory(Main.TrailsFeature(p));
            e.setCancelled(true);
        }
        if (item.equals(ShopItems.GB1(p))) {
            p.openInventory(Main.ShopDefault(p));
            e.setCancelled(true);
        }
        if (item.equals(DefaultKits.DefaultKitYT(p))) {
            ActionBarAPI.sendActionBar(p, Main.prefix + Main.color("&a&lEnjoy for your kit &e❤"));
            p.closeInventory();
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (item.equals(DefaultKits.DefaultKitKING(p))) {
            ActionBarAPI.sendActionBar(p, Main.prefix + Main.color("&a&lEnjoy for your kit &e❤"));
            p.closeInventory();
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (item.equals(DefaultKits.DefaultKitMVP(p))) {
            ActionBarAPI.sendActionBar(p, Main.prefix + Main.color("&a&lEnjoy for your kit &e❤"));
            p.closeInventory();
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (item.equals(DefaultKits.DefaultKitVIP(p))) {
            ActionBarAPI.sendActionBar(p, Main.prefix + Main.color("&a&lEnjoy for your kit &e❤"));
            p.closeInventory();
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            e.setCancelled(true);
        }
        if (item.equals(DefaultKits.DefaultKit(p))) {
            ActionBarAPI.sendActionBar(p, Main.prefix + Main.color("&fYou already have this kit"));
            p.closeInventory();
            p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
            e.setCancelled(true);
        }
       }
      }

