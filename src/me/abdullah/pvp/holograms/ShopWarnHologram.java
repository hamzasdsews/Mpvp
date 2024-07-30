package me.abdullah.pvp.holograms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.ranksup.RankAPI;

public class ShopWarnHologram {

	
	
	private List<ArmorStand> armorstand = new ArrayList<>();
	private Location location;
	private void createHologram(Player p)
	{
		Location loc = location.clone();
		armorstand.add(createArmorStand("§c★ §7You must have §aTokens on Lobby §7to buy an item §c★", loc.add(0, 0.12, 0)));
		armorstand.add(createArmorStand("§c★ §7if you bought Trail or Battle Cry §c★ ", loc.add(0, -0.24, 0)));
		armorstand.add(createArmorStand("§7Go to §b§lFeatures §7Menu §7to §a§lEnable it!", loc.add(0, -0.48, 0)));
		armorstand.add(createArmorStand("§con kill player §c§lWARNING: §6⚔ = XP§8, §6✪ = Tokens.", loc.add(0, -0.72, 0)));
	}
	public ShopWarnHologram(Location location, Player p) {
		this.location = location;
		createHologram(p);
	}
	private ArmorStand createArmorStand(String name, Location location) {
		ArmorStand armorStand = (ArmorStand)location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorStand.setGravity(false);
		armorStand.setVisible(false);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		armorStand.setMetadata("TopPVP", new FixedMetadataValue(Main.getInstance(), ""));
		return armorStand;
	}
   }
