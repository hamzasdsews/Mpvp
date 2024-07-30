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
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.ranksup.RankAPI;

public class JoinHologram {

	
	
	private List<ArmorStand> armorstand = new ArrayList<>();
	private Location location;
	private void createHologram(Player p)
	{
		Location loc = location.clone();
		armorstand.add(createArmorStand("§cTeaming is not allowed,", loc));
	}
	public JoinHologram(Main main, Location location, Player p) {
		this.location = location;
		createHologram(p);
	}
	private ArmorStand createArmorStand(String name, Location location) {
		ArmorStand armorStand = (ArmorStand)location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorStand.setGravity(false);
		armorStand.setVisible(false);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		return armorStand;
	}
   }
