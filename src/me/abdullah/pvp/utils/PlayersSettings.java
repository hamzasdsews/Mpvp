package me.abdullah.pvp.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class PlayersSettings {
    public static Integer getTime(String name) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Time");
        return scramblo;
    }
    public static void addTime(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Time");
        cfg.set(name + ".Time", scramblo += amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void removeTime(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Time");
        cfg.set(name + ".Time", scramblo -= amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setTime(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        cfg.set(name + ".Time", amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Integer getscramble(String name) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Scramble");
        return scramblo;
    }
    public static void addscramble(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Scramble");
        cfg.set(name + ".Scramble", scramblo += amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void removescramble(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        int scramblo = cfg.getInt(name + ".Scramble");
        cfg.set(name + ".Scramble", scramblo -= amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setscramble(String name, int amount) {
        File file = new File("plugins/NaarMC_PVP", "Players Settings.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        cfg.set(name + ".Scramble", amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}