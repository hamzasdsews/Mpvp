/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Blaze
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.entity.Wither
 *  org.bukkit.entity.WitherSkull
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityShootBowEvent
 *  org.bukkit.event.entity.EntityTargetEvent
 *  org.bukkit.event.player.PlayerInteractEntityEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryView
 */
package me.abdullah.pvp.utils;

import java.util.ArrayList;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import me.abdullah.pvp.a.main.Main;

public class EntityUtils
implements Listener {
	String prefix = Main.prefix;
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Location loc = e.getPlayer().getLocation();
        World world = e.getPlayer().getWorld();
        if (e.getRightClicked().getType() == EntityType.SKELETON && e.getRightClicked().getCustomName().equalsIgnoreCase("§bShop")) {
                p.openInventory(Main.ShopDefault(p));
                world.playEffect(loc, Effect.HEART, 10);
                e.setCancelled(true);
              } else {
        	e.setCancelled(true);
        }}

    @EventHandler
    public void onDamagedbyblaze(EntityTargetEvent e) {
        if (e.getEntity() instanceof Blaze) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onShootSkeleton(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
    }
}

