package me.abdullah.pvp.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class PingAPI implements Listener{
    public static Integer size = 1;
    
    
    @EventHandler 
    public void pingPL(ServerListPingEvent e) {
        
    e.setMaxPlayers(size);    
    
    }
    
    @EventHandler
    public void onJPL(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        
        size=size+1;
    }
    
    @EventHandler
    public void onQPL(PlayerQuitEvent e) {
        
        Player p = e.getPlayer();
        
        size=size-1;
    }
}