package me.abdullah.pvp.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.abdullah.pvp.a.main.Main;

public class FlintAPI implements Listener{
	
	
	
    @EventHandler
    public void onsa(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getDurability() == 64 && e.getPlayer().getItemInHand().getType() == Material.FLINT_AND_STEEL) {
            p.sendMessage(Main.color(Main.prefix + "&cFlint is out of Stock!"));
            e.setCancelled(true);
        } else {
            p.getItemInHand().setDurability((short)(e.getPlayer().getItemInHand().getDurability() + 1));
            p.updateInventory();
        }

    }
}
