package me.abdullah.pvp.api;

import me.abdullah.pvp.holograms.JoinHologram;
import me.abdullah.pvp.holograms.TopHologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HologramsAPI {




    public static void all(Player p) {
        new TopHologram(new Location(Bukkit.getWorlds().get(0), -572.820,102.15473,-2576.300), p);
    }
}
