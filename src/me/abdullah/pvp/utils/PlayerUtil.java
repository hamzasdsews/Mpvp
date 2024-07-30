package me.abdullah.pvp.utils;

import org.bukkit.*;
import java.util.*;

public class PlayerUtil
{
	public static String getUUID(String Playername) {
        return Bukkit.getPlayer(Playername).getUniqueId().toString();
    }
    
	public static String getExactName(String Playername) {
        return Bukkit.getPlayer(Playername).getName().toString();
    }
    
    public static String getExactName(UUID UniqueID) {
        return Bukkit.getPlayer(UniqueID).getName().toString();
    }
    
    public static String getNormalName(String str) {
        return str.replace("§e", "").replace("§4", "").replace("§d", "").replace("§c", "").replace("§d", "").replace("§6", "").replace("§a", "").replace("§e", "").replace("§9", "").replace("§f", "").replace("§5", "").replace("§b", "");
    }
}
