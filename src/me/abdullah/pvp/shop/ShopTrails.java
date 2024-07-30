package me.abdullah.pvp.shop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;

public class ShopTrails {
	public static ItemStack TrailsFeatures()
	{
		ItemStack i = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&aTrails"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add("§a➡ Click to View!");
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
    public static ItemStack HeartTrail(Player p) {
        ItemStack item = new ItemStack(Material.RED_ROSE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&c&lHearts"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a3000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack HeartTrailYes(Player p) {
        ItemStack item = new ItemStack(Material.RED_ROSE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&c&l&c&lHearts"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§a➟ You own this trail §e★");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack HeartClickable(Player p) {
        ItemStack item = new ItemStack(Material.RED_ROSE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&c&l&c&l&c&lHearts"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack RemoveTrail(Player p) {
        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&4✗ &cRemove trail &4✗"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.color("&bUse this for:"));
        lore.add(Main.color("&aContinue choose feature."));
        lore.add(Main.color("&aAnd removeing all your trails"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack SmokeTrail(Player p) {
        ItemStack item = new ItemStack(Material.STRING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&7&lSmoke"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a3000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack SmokeTrailYes(Player p) {
        ItemStack item = new ItemStack(Material.STRING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&7&l&7&lSmoke"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§a➟ You own this trail §e★");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack SmokeClickable(Player p) {
        ItemStack item = new ItemStack(Material.STRING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&7&l&7&l&7&lSmoke"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack LavaPoPTrail(Player p) {
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6&lLavaPoP"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a3000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack LavaPoPTrailYes(Player p) {
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6&l&6&lLavaPoP"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§a➟ You own this trail §e★");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack LavaPoPClickable(Player p) {
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6&l&6&l&6&lLavaPoP"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    } 
}
