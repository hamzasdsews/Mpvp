package me.abdullah.pvp.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.abdullah.pvp.a.main.Main;

public class FileManager
{
    public static File WarpFile;
    public static FileConfiguration WarpConfiguration;
    public static File ArenasFile;
    public static FileConfiguration ArenasConfiguration;
    
    static {
        FileManager.WarpFile = new File(Main.sharedInstance().getDataFolder(), "Warp.yml");
        FileManager.WarpConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(FileManager.WarpFile);
        FileManager.ArenasFile = new File(Main.sharedInstance().getDataFolder(), "Arenas.yml");
        FileManager.ArenasConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(FileManager.ArenasFile);
    }
    
    public static boolean ArenaExists(String Arena) {
        return FileManager.ArenasConfiguration.get("Arena." + Arena) != null;
    }
    
    public static int getSpawnAmount(String Arena) {
        if (ArenaExists(Arena)) {
            return FileManager.ArenasConfiguration.getInt("Arena." + Arena + ".SpawnAmount");
        }
        return 0;
    }
    
    public static void setSpawnAmount(String Arena, int Amount) {
        if (ArenaExists(Arena)) {
            FileManager.ArenasConfiguration.set("Arena." + Arena + ".SpawnAmount", (Object)Amount);
            saveArenasConfig();
        }
    }
    
    public static void createArena(String Arena, String Bauteam) {
        if (!ArenaExists(Arena)) {
            FileManager.ArenasConfiguration.set("Arena." + Arena + ".WhoBuilt", (Object)Bauteam);
            FileManager.ArenasConfiguration.set("Arena." + Arena + ".SpawnAmount", (Object)0);
            List<String> Arenas = getArenas();
            Arenas.add(Arena);
            FileManager.ArenasConfiguration.set("Arenas", (Object)Arenas);
            saveArenasConfig();
        }
    }
    
    public static List<String> getArenas() {
        return (List<String>)FileManager.ArenasConfiguration.getStringList("Arenas");
    }
    
    public static void saveArenasConfig() {
        try {
            if (FileManager.ArenasFile.exists()) {
                FileManager.ArenasConfiguration.save(FileManager.ArenasFile);
            }
        }
        catch (IOException ex) {}
    }
    
    public static void saveConfig() {
        try {
            if (FileManager.WarpFile.exists()) {
                FileManager.WarpConfiguration.save(FileManager.WarpFile);
            }
        }
        catch (IOException ex) {}
    }
    
    public static void createArenasConfig() {
        try {
            if (Main.sharedInstance().getDataFolder().exists()) {
                if (!FileManager.ArenasFile.exists()) {
                    FileManager.ArenasFile.createNewFile();
                }
            }
            else if (!Main.sharedInstance().getDataFolder().exists()) {
                Main.sharedInstance().getDataFolder().mkdir();
                FileManager.ArenasFile.createNewFile();
            }
        }
        catch (IOException ex) {}
    }
    
    public static void createConfig() {
        try {
            if (Main.sharedInstance().getDataFolder().exists()) {
                if (!FileManager.WarpFile.exists()) {
                    FileManager.WarpFile.createNewFile();
                }
            }
            else if (!Main.sharedInstance().getDataFolder().exists()) {
                Main.sharedInstance().getDataFolder().mkdir();
                FileManager.WarpFile.createNewFile();
            }
        }
        catch (IOException ex) {}
    }
}
