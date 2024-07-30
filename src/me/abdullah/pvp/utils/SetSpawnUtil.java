package me.abdullah.pvp.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnUtil {
    public static File desert = new File("plugins/NaarMC_PVP", "Spawn.yml");
    public static YamlConfiguration LocationWorldDesert = YamlConfiguration.loadConfiguration(desert);
    
    
	  public static void set(Player p) {
	        Location loc = p.getLocation();
	        LocationWorldDesert.set("Spawn.X", loc.getX());
	        LocationWorldDesert.set("Spawn.Y", loc.getY());
	        LocationWorldDesert.set("Spawn.Z", loc.getZ());
	        LocationWorldDesert.set("Spawn.Yaw", Float.valueOf(loc.getYaw()));
	        LocationWorldDesert.set("Spawn.Pitch", Float.valueOf(loc.getPitch()));
	        LocationWorldDesert.set("Spawn.World", loc.getWorld().getName());
	        try {
	        	LocationWorldDesert.save(desert);
	        }
	        catch (IOException iOException) {
	        }
	    }
	    public static void teleport(Player p) {
	        try {
	            Location loc = p.getLocation();
	            loc.setX(LocationWorldDesert.getDouble("Spawn.X"));
	            loc.setY(LocationWorldDesert.getDouble("Spawn.Y"));
	            loc.setZ(LocationWorldDesert.getDouble("Spawn.Z"));
	            loc.setYaw((float) LocationWorldDesert.getDouble("Spawn.Yaw"));
	            loc.setPitch((float) LocationWorldDesert.getDouble("Spawn.Pitch"));
	            loc.setWorld(Bukkit.getWorld(LocationWorldDesert.getString("Spawn.World")));
	            p.teleport(loc);
	            }
	        catch (Exception e) {
	        }
	    }
}
