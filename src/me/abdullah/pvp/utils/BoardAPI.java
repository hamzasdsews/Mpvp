/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.scoreboard.DisplaySlot
 *  org.bukkit.scoreboard.Objective
 *  org.bukkit.scoreboard.Score
 *  org.bukkit.scoreboard.Scoreboard
 *  org.bukkit.scoreboard.ScoreboardManager
 */
package me.abdullah.pvp.utils;
import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.ranksup.RankAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.naarmc.mysql.api.TabAPI;


public class BoardAPI { 
	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM \u00d7 HH:mm");
    static LuckPerms api = LuckPermsProvider.get();
	static Date date = new Date();
    public static void onScoreboard(Player p) {
    	ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective o = board.registerNewObjective("PVP", "dummy");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(Main.color("&e&lPVP &7v0.1"));
        // 
        int killstreaks = p.getLevel();
        int points = PVPStats.getPoints(p.getName());
        int kills = PVPStats.getKills(p.getName());
        
        o.getScore("§1").setScore(13);
        
        o.getScore("§a§lPrestige").setScore(12);
        
        o.getScore("§8» §7§7 " + RankAPI.getRank(p)).setScore(11);
        
        o.getScore("§2").setScore(10);
        
        o.getScore("§e§lPoints").setScore(9);
        
        o.getScore("§8» §7§7§7" + points).setScore(8);
        
        o.getScore("§3").setScore(7);
        
        o.getScore("§d§lKills").setScore(6);
        
        o.getScore("§8» §7§7§7" + kills).setScore(5);
        
        o.getScore("§4").setScore(4);        
        
        o.getScore("§b§lKillStreak").setScore(3);
        
        o.getScore("§8» §e" + p.getLevel()).setScore(2);
        
        o.getScore("§5").setScore(1);
               
        o.getScore("§7play.naarmc.net").setScore(0);
        
        p.setScoreboard(board);          
        TabAPI.UpdateTablist(p);
    }
    public static String getMap(Player p)
    {
    	World w = p.getWorld();
    	String msg = "";
    if (w.getName().equalsIgnoreCase("PVP")) {
    	
    	msg = ("§fDesert");
    }
    else if (w.getName().equalsIgnoreCase("PVP2")) {
    	
    	msg = ("§fSea");
    }
    else if (w.getName().equalsIgnoreCase("PVP3")) {
    	
    	msg = ("§fCF");
    }
    return msg;
   }
  }