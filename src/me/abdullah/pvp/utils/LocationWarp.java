
package me.abdullah.pvp.utils;

import org.bukkit.configuration.file.*;
import org.bukkit.*;

public class LocationWarp
{
    public static FileConfiguration Cfg;
    
    static {
        LocationWarp.Cfg = FileManager.WarpConfiguration;
    }
    
    public static Location get(String Path) {
        if (FileManager.WarpFile.exists() && LocationWarp.Cfg.get(Path) != null) {
            World World = Bukkit.getWorld(LocationWarp.Cfg.getString(String.valueOf(String.valueOf(Path)) + ".World"));
            double X = LocationWarp.Cfg.getDouble(String.valueOf(String.valueOf(Path)) + ".X");
            double Y = LocationWarp.Cfg.getDouble(String.valueOf(String.valueOf(Path)) + ".Y") + 1.0;
            double Z = LocationWarp.Cfg.getDouble(String.valueOf(String.valueOf(Path)) + ".Z");
            float Yaw = (float)LocationWarp.Cfg.getDouble(String.valueOf(String.valueOf(Path)) + ".Yaw");
            float Pitch = (float)LocationWarp.Cfg.getDouble(String.valueOf(String.valueOf(Path)) + ".Pitch");
            return new Location(World, X, Y, Z, Yaw, Pitch);
        }
        return null;
    }
    
    public static void set(Location Loc, String Path) {
        if (FileManager.WarpFile.exists()) {
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".World", (Object)Loc.getWorld().getName());
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".X", (Object)Loc.getX());
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".Y", (Object)Loc.getY());
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".Z", (Object)Loc.getZ());
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".Yaw", (Object)Loc.getYaw());
            LocationWarp.Cfg.set(String.valueOf(String.valueOf(Path)) + ".Pitch", (Object)Loc.getPitch());
            FileManager.saveConfig();
        }
    }
}
