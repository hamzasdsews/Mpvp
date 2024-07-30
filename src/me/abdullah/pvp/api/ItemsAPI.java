package me.abdullah.pvp.api;

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
	    gm.setDisplayName("§f§lTeleporter");
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
	  public static ItemStack Quit()
	  {
	    ItemStack g = new ItemStack(Material.SLIME_BALL);
	    ItemMeta gm = g.getItemMeta();
	    gm.setDisplayName("§bBack to Game.");
	    g.setItemMeta(gm);
	    return g;
	  }
	  public static ItemStack Quit2()
	  {
	    ItemStack g = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta gm = g.getItemMeta();
	    gm.setDisplayName("§e§lExit Staff mode.");
	    g.setItemMeta(gm);
	    return g;
	  }
  public static ItemStack FlySpeed() {
      ItemStack g = new ItemStack(Material.FEATHER);
      ItemMeta gm = g.getItemMeta();
      gm.setDisplayName("§3§lFly Speed");
	  ArrayList<String> lore = new ArrayList<String>();
	  lore.add("");
	  lore.add("§8(§6§lVIP §aOr High§8)");
	  lore.add("§7Use this item to boost your fly!");
	  lore.add("");
	  lore.add("§b▶ Right-Click to open GUI!");
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
