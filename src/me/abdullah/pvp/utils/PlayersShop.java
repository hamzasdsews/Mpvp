package me.abdullah.pvp.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayersShop {
	  public static Integer getHeart(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".Heart trail");
	        return scramblo;
	    }
	    public static void addHeart(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".Heart trail");
	        cfg.set(p.getName() + ".Trails" + ".Heart trail", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setHeart(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName()  + ".Trails" + ".Heart trail", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
		  public static Integer getSmoke(Player p) {
		        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
		        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".Smoke trail");
		        return scramblo;
		    }
		    public static void addSmoke(Player p, int amount) {
		        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
		        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".Smoke trail");
		        cfg.set(p.getName() + ".Trails" + ".Smoke trail", scramblo += amount);
		        try {
		            cfg.save(file);
		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    public static void setSmoke(Player p, int amount) {
		        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
		        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		        cfg.set(p.getName()  + ".Trails" + ".Smoke trail", amount);
		        try {
		            cfg.save(file);
		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        }
		    }	    
	    
			  public static Integer getLava(Player p) {
			        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
			        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".LavaPoP trail");
			        return scramblo;
			    }
			    public static void addLava(Player p, int amount) {
			        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
			        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			        int scramblo = cfg.getInt(p.getName()  + ".Trails" + ".LavaPoP trail");
			        cfg.set(p.getName() + ".Trails" + ".LavaPoP trail", scramblo += amount);
			        try {
			            cfg.save(file);
			        }
			        catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			    public static void setLava(Player p, int amount) {
			        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
			        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			        cfg.set(p.getName()  + ".Trails" + ".LavaPoP trail", amount);
			        try {
			            cfg.save(file);
			        }
			        catch (IOException e) {
			            e.printStackTrace();
			        }
			    }	    	    
	    
	    
	    
	    
	   public static Integer getVillagerdeath(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName()  + ".BattleCry" + ".Villager Death");
	        return scramblo;
	    }
	    public static void addVillagerdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName()  + ".BattleCry" + ".Villager Death");
	        cfg.set(p.getName() + ".BattleCry" + ".Villager Death", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setVillagerdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName()  + ".BattleCry" + ".Villager Death", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    //                     Zombie Battle Cry
	    public static Integer getZombiedeath(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Zombie Death");
	        return scramblo;
	    }
	    public static void addZombiedeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".Zombie Death");
	        cfg.set(p.getName() + ".BattleCry" + ".Zombie Death", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setZombiedeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".BattleCry" + ".Zombie Death", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    //                         Bat BattleCry
	    public static Integer getBatdeath(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Bat Death");
	        return scramblo;
	    }
	    public static void addBatdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Bat Death");
	        cfg.set(p.getName() + ".BattleCry" + ".Bat Death", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setBatdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".BattleCry" + ".Bat Death", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    //                         Wolf BattleCry	    
	    public static Integer getWolfdeath(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Wolf Death");
	        return scramblo;
	    }
	    public static void addWolfdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Wolf Death");
	        cfg.set(p.getName() + ".BattleCry" + ".Wolf Death", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setWolfdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".BattleCry" + ".Wolf Death", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    //                         Cat Meow BattleCry	    
	    public static Integer getCatMeowdeath(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Cat Meow");
	        return scramblo;
	    }
	    public static void addCatMeowdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".BattleCry" + ".Cat Meow");
	        cfg.set(p.getName() + ".BattleCry" + ".Cat Meow", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setCatMeowdeath(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".BattleCry" + ".Cat Meow", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    //                     KillEffect Firework Battle Cry
	    public static Integer getFirework(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".KillEffect" + ".Firework");
	        return scramblo;
	    }
	    public static void addFirework(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".Firework");
	        cfg.set(p.getName() + ".KillEffect" + ".Firework", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setFirework(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".KillEffect" + ".Firework", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    //                     KillEffect Explode Battle Cry
	    public static Integer getExplode(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".KillEffect" + ".Explode");
	        return scramblo;
	    }
	    public static void addExplode(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".Explode");
	        cfg.set(p.getName() + ".KillEffect" + ".Explode", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setExplode(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".KillEffect" + ".Explode", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    //                     KillEffect Strike Battle Cry
	    public static Integer getStrike(Player p) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".KillEffect" + ".Strike");
	        return scramblo;
	    }
	    public static void addStrike(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        int scramblo = cfg.getInt(p.getName() + ".Strike");
	        cfg.set(p.getName() + ".KillEffect" + ".Strike", scramblo += amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void setStrike(Player p, int amount) {
	        File file = new File("plugins/NaarMC_PVP/Stats", p.getName() + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        cfg.set(p.getName() + ".KillEffect" + ".Strike", amount);
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
