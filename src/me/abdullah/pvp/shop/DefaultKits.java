package me.abdullah.pvp.shop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class DefaultKits {
    public static LuckPerms api = LuckPermsProvider.get();
    public static ItemStack DefaultKitYT(Player p) {
        ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);        
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&5YouTuber"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.F("&a➟ Click to select"));
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack DefaultKitKING(Player p) {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);        
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&aKING"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.F("&a➟ Click to select"));
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item; 
    }
    public static ItemStack DefaultKitMVP(Player p) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);        
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&bMVP"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.F("&a➟ Click to select"));
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack DefaultKitVIP(Player p) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);        
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6VIP"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.F("&a➟ Click to select"));
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item; 
   }
    public static ItemStack DefaultKit(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);        
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&7Member"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.F("&a➟ Click to select"));
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item; 
   }
}
