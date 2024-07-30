/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.combat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class CombatTimer
implements Runnable {
    public static int combatTime = 10;
    public static HashMap<Player, Integer> combat = new HashMap();
    public void run() {
        ArrayList<Player> list = new ArrayList<Player>();
        for (Player p : combat.keySet()) {
            if (combat.get(p) >= combatTime) {
                if (Main.plugin.getConfig().getBoolean("Combat.NoLonger")) {
                   p.sendMessage(Main.prefix + Main.color("&a&lYou are now longer under attack"));
                }
                list.add(p);
                continue;
            }
            combat.replace(p, combat.get(p) + 1);
        }
        for (Player player : list) {
            combat.remove(player);
        }
    }
}

