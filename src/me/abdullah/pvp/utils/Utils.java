/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class Utils {
    private static Utils instance;
	private ArrayList FreezeList = new ArrayList();
    private FileConfiguration config;
    private String updatelink;
    private boolean freezeallcheck = false;
    private boolean newupdate = false;

    public static synchronized Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

	public ArrayList getFreezeList() {
        return this.FreezeList;
    }

    public FileConfiguration getConfig() {
        this.config = Main.sharedInstance().getConfig();
        return this.config;
    }

    public FileConfiguration getMessages() {
        return Main.sharedInstance().getConfig();
    }

    public String getUpdateLink() {
        return this.updatelink;
    }

    public Boolean getFreezeallcheck() {
        return this.freezeallcheck;
    }

    public Boolean getBoolUpdate() {
        return this.newupdate;
    }

	public void setFreeze(Player p) {
        this.FreezeList.add(p);
    }

    public void removeFreeze(Player p) {
        this.FreezeList.remove((Object)p);
    }

    public void setBoolFreezeAll(boolean b) {
        this.freezeallcheck = b;
    }

    public void setBoolUpdate(boolean b) {
        this.newupdate = b;
    }

    public void setUpdateLink(String b) {
        this.updatelink = b;
    }

	public void correctPosition(Player player) {
        if (!player.isOnGround()) {
            World world = player.getWorld();
            double x = player.getLocation().getX();
            double z = player.getLocation().getZ();
            double y = player.getWorld().getHighestBlockAt((int)x, (int)z).getY();
            Location teleport = new Location(world, x, y, z);
            player.teleport(teleport);
        }
    }
}

