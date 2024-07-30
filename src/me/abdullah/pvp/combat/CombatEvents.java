/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.EntityShootBowEvent
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 */
package me.abdullah.pvp.combat;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.utils.ActionBarAPI;

public class CombatEvents
implements Listener {
    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void onEntityHit(EntityDamageByEntityEvent e) {
        if (e.getDamage() == 0.0) {
            return;
        }
        if (e.isCancelled()) {
            return;
        }
        if (e.getEntity() instanceof Player) {
            if (CombatTimer.combat.containsKey(((Player)e.getEntity()))) {
                CombatTimer.combat.put((Player)e.getEntity(), 0);
            } else {
                CombatTimer.combat.put((Player)e.getEntity(), 0);
                    e.getEntity().sendMessage(Main.prefix + "§c§lYou are now under attack");
            }
            if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
                Player p2 = (Player)e.getDamager();
                Player p = (Player)e.getEntity();
                p2.setFlying(false);
                p2.setAllowFlight(false);
                if (CombatTimer.combat.containsKey(p2)) {
                    CombatTimer.combat.put(p2, 0);
                } else {
                    CombatTimer.combat.put(p2, 0);
                        p2.sendMessage(Main.prefix + "§c§lYou are now under attack");
                    }
                }
            }
        }

//    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
//    public void onQuit(PlayerQuitEvent e) {
//        Player p = e.getPlayer();
//        if (CombatTimer.combat.containsKey(p)) {
//            p.sendMessage(Language.CONFIG_PREFIX  + "\u00a7bYou are not allowed to leave in combat mode!");
//            p.setHealth(0.0);
//            CombatTimer.combat.remove(p);
//        } else {
//            p.setHealth(20.0);
//        }
//    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void onEntityShootBow(EntityShootBowEvent e) {
        Player p = (Player)e.getEntity();
        World w = p.getWorld();
        if (e.isCancelled()) {
            return;
        }
        if (e.getEntity() instanceof Player) {
            p.setFlying(false);
            p.setAllowFlight(false);
            if (CombatTimer.combat.containsKey(p)) {
                CombatTimer.combat.put(p, 0);
            } else {
                CombatTimer.combat.put(p, 0);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void onEntityHit(EntityDamageEvent e) {
        if (e.getDamage() == 0.0) {
            return;
        }
        if (e.isCancelled()) {
            return;
        }
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) && e.getEntity() instanceof Player) {
            if (CombatTimer.combat.containsKey(e.getEntity())) {
                CombatTimer.combat.put((Player)e.getEntity(), 0);
            } else {
                CombatTimer.combat.put((Player)e.getEntity(), 0);
                    e.getEntity().sendMessage(Main.prefix + "§c§lYou are now under attack");
                }
            }
        }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        World w = p.getWorld();
        if (CombatTimer.combat.containsKey(e.getPlayer())) {
        	if (e.getMessage().equals("/spawn") || e.getMessage().equals("/hub") || e.getMessage().equals("/lobby"))
        	{
            p.sendMessage(Main.prefix + Main.color("§cYou can't type this command in combat."));
            e.setCancelled(true);
        	} else {
            e.setCancelled(false);
        }
    }
   }
}

