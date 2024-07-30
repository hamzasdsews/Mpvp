package me.abdullah.pvp.utils;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class KitAPI
{
    public static boolean get(ItemStack I, Material Material, String Displayname) {
        return I != null && I.hasItemMeta() && I.getItemMeta().hasDisplayName() && I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname) && I.getType() == Material;
    }
    
    public static ItemStack createSkull(Material Material, int Amount, String Playername, String Displayname, ArrayList<String> Lore) {
        ItemStack I = new ItemStack(Material, Amount, (short)3);
        SkullMeta Im = (SkullMeta)I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setOwner(Playername);
        Im.setLore(Lore);
        I.setItemMeta(Im);
        return I;
    }
    
    public static ItemStack createSkull(Material Material, int Amount, String Playername, String Displayname) {
        ItemStack I = new ItemStack(Material, Amount, (short)3);
        SkullMeta Im = (SkullMeta)I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setOwner(Playername);
        I.setItemMeta(Im);
        return I;
    }
    
    public static ItemStack createItem(Material Material, int Amount, int Short, String Displayname, ArrayList<String> Lore) {
        ItemStack I = new ItemStack(Material, Amount, (short)Short);
        ItemMeta Im = I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setLore(Lore);
        Im.spigot().setUnbreakable(true);
        I.setItemMeta(Im);
        return I;
    }
    
    public static ItemStack createItem(Material Material, int Amount, int Short, String Displayname, ArrayList<String> Lore, int x) {
        ItemStack I = new ItemStack(Material, Amount, (short)Short);
        ItemMeta Im = I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setLore(Lore);
        I.setDurability((short)63);
        I.setItemMeta(Im);
        return I;
    }
}
