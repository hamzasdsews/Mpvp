package me.abdullah.pvp.Listeners;

import com.naarmc.mysql.api.RegionsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import com.naarmc.mysql.api.ArenaAPI;
import com.naarmc.mysql.main.Main;

import me.abdullah.pvp.utils.PlayersShop;


public class TrailsEvents implements Listener{
    public static int heart;
    public static int smoke;
    public static int lavapop;

	@EventHandler
    public void trailhearts(ProjectileLaunchEvent e) {
		Projectile entity = e.getEntity();
		EntityType type = entity.getType();
		if (e.getEntity().getShooter() instanceof Player) {
			Player p = (Player) e.getEntity().getShooter();
			if (PlayersShop.getHeart(p) == 2) {

				if (type == EntityType.ARROW && RegionsAPI.inSideSpawn(p.getLocation()) || RegionsAPI.inSideTrade(p.getLocation()) || RegionsAPI.inSideVIP(p.getLocation()) || RegionsAPI.inSideMVP(p.getLocation()) || RegionsAPI.inSideKING(p.getLocation()) || RegionsAPI.inSideYT(p.getLocation())) {
					e.setCancelled(true);
				} else {
					if (PlayersShop.getHeart(p) == 2 && type == EntityType.ARROW ) {
						heart = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
						public void run() {
							World w = entity.getWorld();
							Location l = entity.getLocation();
							w.playEffect(l, Effect.HEART, 1);
						}
					}, 1, 1);

				}
			}

		}
	}}
    @EventHandler(priority = EventPriority.HIGHEST)
    public void trailsmoke(ProjectileLaunchEvent e) {
		Projectile entity = e.getEntity();
		EntityType type = entity.getType();
		if (e.getEntity().getShooter() instanceof Player) {
			Player p = (Player) e.getEntity().getShooter();
			if (PlayersShop.getSmoke(p) == 2) {

				if (type == EntityType.ARROW && RegionsAPI.inSideSpawn(p.getLocation()) || RegionsAPI.inSideTrade(p.getLocation()) || RegionsAPI.inSideVIP(p.getLocation()) || RegionsAPI.inSideMVP(p.getLocation()) || RegionsAPI.inSideKING(p.getLocation()) || RegionsAPI.inSideYT(p.getLocation())) {
					e.setCancelled(true);
				} else {
					if (PlayersShop.getSmoke(p) == 2 && type == EntityType.ARROW) {
						smoke = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
							public void run() {
								World w = entity.getWorld();
								Location l = entity.getLocation();
								w.playEffect(l, Effect.LARGE_SMOKE, 10);
							}
						}, 1, 1);

					}
				}

			}

		}
	}



    @EventHandler(priority = EventPriority.HIGHEST)
    public void traillavapop(ProjectileLaunchEvent e) {
		Projectile entity = e.getEntity();
		EntityType type = entity.getType();
		if (e.getEntity().getShooter() instanceof Player) {
			Player p = (Player) e.getEntity().getShooter();
			if (PlayersShop.getLava(p) == 2) {

				if (type == EntityType.ARROW && RegionsAPI.inSideSpawn(p.getLocation()) || RegionsAPI.inSideTrade(p.getLocation()) || RegionsAPI.inSideVIP(p.getLocation()) || RegionsAPI.inSideMVP(p.getLocation()) || RegionsAPI.inSideKING(p.getLocation()) || RegionsAPI.inSideYT(p.getLocation())) {
					e.setCancelled(true);
				} else {
					if (PlayersShop.getLava(p) == 2 && type == EntityType.ARROW) {
						lavapop = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
							public void run() {
								World w = entity.getWorld();
								Location l = entity.getLocation();
								w.playEffect(l, Effect.LAVA_POP, 10);
							}
						}, 1, 1);

					}
				}

			}

		}
	}


            @EventHandler
            public void onProjectileHitHeart(ProjectileHitEvent e){
            if(e.getEntity() instanceof Arrow){
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(smoke);
                Bukkit.getScheduler().cancelTask(lavapop);
            }
           }
        }