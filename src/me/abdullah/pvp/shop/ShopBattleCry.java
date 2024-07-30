package me.abdullah.pvp.shop;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.SpawnEgg;

import me.abdullah.pvp.a.main.Main;

public class ShopBattleCry {
	public static ItemStack BattleCryOpenFeature()
	{
		ItemStack i = new ItemStack(Material.NOTE_BLOCK);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&aBattle Cry"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add("§a➡ Click to View!");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;	
	}
	
	
	
	//           -     Villager Death     -
	
    public static ItemStack VillagerDeathBattleCry()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eVillager Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack VillagerDeathYes()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&e&eVillager Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§e➟ You own this battle cry §e★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack VillagerDeathClickable()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 120);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&e&e&eVillager Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
	
	
	
	//           -     Zombie Death     -
	    
    public static ItemStack ZombieDeathBattleCry()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 54);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&bZombie Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack ZombieDeathYes()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 54);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&b&bZombie Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§e➟ You own this battle cry §e★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack ZombieDeathClickable()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 54);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&b&b&bZombie Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     Bat Death     -
	
    public static ItemStack BatDeathBattleCry()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&fBat Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack BatDeathYes()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&f&fBat Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§e➟ You own this battle cry §e★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack BatDeathClickable()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&f&f&fBat Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     Wolf Death     -
	
    public static ItemStack WolfDeathBattleCry()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&3Wolf Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack WolfDeathYes()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&e&3Wolf Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§e➟ You own this battle cry §e★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack WolfDeathClickable()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&3&3&3Wolf Death"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     CatMeow     -
	
    public static ItemStack CatMeowBattleCry()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 36);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&dCat Meow"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack CatMeowYes()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 36);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&d&dCat Meow"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§e➟ You own this battle cry §e★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack CatMeowClickable()
    {
    	ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, (byte) 36);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&d&d&dCatMeow"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     KillEffect -> Firework     -
	
    public static ItemStack FireworkBattleCry()
    {
    	ItemStack item = new ItemStack(Material.FIREWORK);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &fFirework"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack FireworkYes()
    {
    	ItemStack item = new ItemStack(Material.FIREWORK);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &f&fFirework"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§8➟ §bYou own this kill effect §4★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack FireworkClickable()
    {
    	ItemStack item = new ItemStack(Material.FIREWORK);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &f&f&fFirework"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     KillEffect -> Explosion     -
	
    public static ItemStack ExplosionBattleCry()
    {
    	ItemStack item = new ItemStack(Material.TNT);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &cExplosion"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack ExplosionYes()
    {
    	ItemStack item = new ItemStack(Material.TNT);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &c&cExplosion"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§8➟ §bYou own this kill effect §4★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack ExplosionClickable()
    {
    	ItemStack item = new ItemStack(Material.TNT);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &c&c&cExplosion"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
	
	
	
	//           -     KillEffect -> Lightning Strike     -
	
    public static ItemStack StrikeBattleCry()
    {
    	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &bLightning Strike"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.F("&7"));
        lore.add(Main.F("&a&lCost"));
        lore.add(Main.F("&a5000 &e✪"));
        lore.add("");
        lore.add(Main.F("&b➟ Click to Purchase"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack StrikeYes()
    {
    	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &b&bLightning Strike"));;
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§8➟ §bYou own this kill effect §4★");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack StrikeClickable()
    {
    	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Main.color("&eKill Effect &8▶ &b&b&bLightning Strike"));;
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§aClick to select");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
		return item;
    }
    public static ItemStack RemoveBattleCry(Player p) {
        ItemStack item = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.F("&e&lRemove Battle Cry"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(Main.color("&7Use this for:"));
        lore.add(Main.color("&7Continue choose feature."));
        lore.add(Main.color("&7And removeing all your Battle Cry!"));
        lore.add("");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
