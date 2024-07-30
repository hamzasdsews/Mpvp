/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.abdullah.pvp.shop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.naarmc.mysql.mysql.LobbyStats;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.BackHead;
import me.abdullah.pvp.utils.KitAPI;
import me.abdullah.pvp.utils.KitsHead;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class ShopItems {
    public static ItemStack Stats(Player p) {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&a&lYour Stats"));
        ArrayList lore = new ArrayList<>();
        lore.add("§6§m=============");
        lore.add("§aTokens: §b" + LobbyStats.getTokens(p));
        lore.add("§aKills: §b" + PVPStats.getKills(p.getName()));
        lore.add("§aDeaths: §b" + PVPStats.getDeaths(p.getName()));
        lore.add("§aRanking: §e" + PVPStats.getRanking(p.getName()));
        lore.add("§aK/D: §b" + PVPStats.getKD(p.getName()));
        lore.add("§6§m=============");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Kits(Player p) {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&3&lKits"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack ArrowTrails(Player p) {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6&lTrails"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack BattleCry(Player p) {
        ItemStack item = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&e&lBattle Cry"));
        ArrayList lore = new ArrayList<>();
        lore.add("");
        lore.add("§7kill sounds for you");
        lore.add("§7and other players!");
        lore.add("§7Kill Effects and more");
        lore.add("");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
//    public static ItemStack OneTimePurchase(Player p) {
//        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
//        ItemMeta meta = item.getItemMeta();
//        meta.setDisplayName(Main.F("&a&lOne-time Purchase"));
//        ArrayList lore = new ArrayList<>();
//        lore.add("");
//        lore.add("§7You will lose these items");
//        lore.add("§7when you leave or die.");
//        lore.add("");
//        meta.setLore(lore);
//        item.setItemMeta(meta);
//        return item;
//    }
    public static ItemStack Perks(Player p) {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&a&lPerks"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Purchase(Player p) {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&b&lFeatures"));
        item.setItemMeta(meta);
        return item;
    }
    
    
    
    // TODO: Kits
    
    
    
    
    
    public static ItemStack GoldKit(Player p) {
        ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&6&lGold Kit"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a► open on 1300+ Points"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack DiamondKit(Player p) {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&b&lDiamond Kit"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a► open on 2600+ Points"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    
    
    
    
    //     TODO: Perks
    
    
    
    
    
    public static ItemStack TnTPerks(Player p) {
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&c&lTNT"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a800 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack CobwebPerks(Player p) {
        ItemStack item = new ItemStack(Material.WEB);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&f&lCobweb"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a300 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Arrow(Player p) {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("More Arrow"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a1200 &e✪"));
        lore.add("");
        lore.add("§7add x1 Arrow");
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack ApplePerks(Player p) {
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&e&lGoldenApple"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a900 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    
    
    
    
    
    
    
    
    
    public static ItemStack GB1(Player p) {
        ItemStack item = new ItemStack(BackHead.getHead(BackHead.Heads.Head));  
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&c&lGoBack"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Zynh1(Player p) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)11);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&9"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Zynh2(Player p) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)14);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&4"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Zynh3(Player p) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)6);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&a"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack Zynh4(Player p) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&e"));
        item.setItemMeta(meta);
        return item;
    }
}

