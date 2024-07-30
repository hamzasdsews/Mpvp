package me.abdullah.pvp.modes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;

public class Flint {
	public static ItemStack Flint(Player p) {
		ItemStack selector = new ItemStack(Material.FLINT_AND_STEEL, 1,(short)63);
		ItemMeta meta = selector.getItemMeta();
		meta.setDisplayName(Main.color("&eFlint"));
		selector.setItemMeta(meta);
		return selector;
	}
}
