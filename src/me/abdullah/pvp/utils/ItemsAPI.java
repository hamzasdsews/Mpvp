package me.abdullah.pvp.utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsAPI 
{
  
	  public static ItemStack Compass()
	  {
	    ItemStack g = new ItemStack(Material.COMPASS);
	    ItemMeta gm = g.getItemMeta();
	    gm.setDisplayName("§b§lTeleporter");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add("");
	    lore.add("§7Right-click to open an inventory that");
	    lore.add("§7allows you to teleport to active players");
	    lore.add("§7players.");
	    lore.add("");
	    lore.add("§b▶ Right-click when held");
	    gm.setLore(lore);
	    g.setItemMeta(gm);
	    return g;
	  }
  public static ItemStack Hotbar() {
      ItemStack g = new ItemStack(Material.REDSTONE_COMPARATOR);
      ItemMeta gm = g.getItemMeta();
      gm.setDisplayName("§e§lHotbar");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add("");
	    lore.add("§7Use this item to edit");
	    lore.add("§7your kit");
	    lore.add("");
	    lore.add("§b▶ Right-Click when held");
	    gm.setLore(lore);
      g.setItemMeta(gm);
      return g;
  }
  
  public static ItemStack Settings() {
      ItemStack g = new ItemStack(Material.BOOK);
      ItemMeta gm = g.getItemMeta();
      gm.setDisplayName("§b§lModify Settings");
      ArrayList<String> lore = new ArrayList<String>();
      lore.add("");
      lore.add("§7Use this to change your");
      lore.add("§7settings in oneversusone.");
      lore.add("");
      lore.add("§b▶ Right-click when held");
      gm.setLore(lore);
      g.setItemMeta(gm);
      return g;
  }
}
