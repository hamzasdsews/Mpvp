package me.abdullah.pvp.apiBars;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.ranksup.RankAPI;
import me.abdullah.pvp.utils.ActionBarAPI;
public class ActionBarsAPI implements Listener{
	@EventHandler
	public void onJoinActionBars(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	    for (Player all : Bukkit.getOnlinePlayers()) {
	    	ActionBarsAPI.ActionBar(all);
	    }
	}
    public static void ActionBar(Player p) {
     for (Player players : Bukkit.getOnlinePlayers()) {
        ActionBarAPI.sendActionBar(players, Main.color(p.getDisplayName() + " &3is want to fight!"));
       }
    }
    public static void SpectateOFF(Player p) { {
      ActionBarAPI.sendActionBar(p, Main.color("&e&l⚉ &b&lSpectate Mode &8➤ &4&lDisabled &e&l⚉"));
       }
    }
    public static void SpectateON(Player p) {
        ActionBarAPI.sendActionBar(p, Main.color("&e&l⚉ &b&lSpectate Mode &8➤ &a&lEnabled &e&l⚉"));
    }
    public static void ActionBar2(Player p) {
           ActionBarAPI.sendActionBar(p, Main.color("&c&l⚔ &a&lChoose Kit to Join the &e&lPVP &a&lZone &c&l⚔"));
          }
    public static void NoClick(Player p) {
        ActionBarAPI.sendActionBar(p, Main.color("&fYou can't click on this item in your inventory."));
       }
    public static void PVPDENY(Player p) {
        ActionBarAPI.sendActionBar(p, Main.color("&4&l✖ &e&lPVP &c&lis not allowed on the Spawn &4&l✖"));
       }
    public static void PlayerDied(Player p) {
        ActionBarAPI.sendActionBar(p, HealthBarAPI.getHealthLeft(p) + " " + "§4✘15 §e✪");   	
    }
    public static void PlayerKilled(Player p) {
        ActionBarAPI.sendActionBar(p, HealthBarAPI.getHealthLeft(p) + " " + "§a✚15 §e✪");   	
    }
   }