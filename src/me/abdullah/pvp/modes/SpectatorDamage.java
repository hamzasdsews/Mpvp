package me.abdullah.pvp.modes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import me.abdullah.pvp.a.main.Main;
public class SpectatorDamage implements Listener{
	
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		try {
			if (e.getDamager() instanceof Player) {
				Player d = (Player)e.getDamager();
				if (Main.spectate.contains(d.getName())) {
					e.setCancelled(true);
				}
			}
		}
		catch (Exception localException) {
			
		}
	}
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		try {
			if ((e.getEntity() instanceof Player)) {
				Player p = (Player)e.getEntity();
				if (Main.spectate.contains(p.getName())) {
					e.setCancelled(true);
				}
			}
		}
		catch (Exception localException) {
			
		}
	}
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e) {
		try {
			if (Main.spectate.contains(e.getPlayer().getName())) {
				e.setCancelled(true);
			}
		}
		catch (Exception localException) {
			
		}	
	}
}
