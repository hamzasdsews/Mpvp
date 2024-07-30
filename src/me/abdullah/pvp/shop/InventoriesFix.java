package me.abdullah.pvp.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.utils.ActionBarAPI;

public class InventoriesFix implements Listener{
	@EventHandler
	public void onInventoryMoveOthers(InventoryClickEvent event)
	{
		Player player = (Player)event.getWhoClicked();
		ItemStack Hand = player.getItemInHand();
		PlayerInventory pInv = player.getInventory();
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("PVP Shop")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Perks")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Kits")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("               §4§nSettings")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Battle Cry")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Available Battle Cry")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Trails")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("Available Trails")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("§5You have an Trail.")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.HOTBAR_SWAP && player.getOpenInventory().getTitle().equalsIgnoreCase("§5You have an Battle Cry.")){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
        }
	}
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryMoveHotKeys(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		ItemStack Hand = player.getItemInHand();
		PlayerInventory pInv = player.getInventory();
        if(event.getAction() == InventoryAction.HOTBAR_SWAP){
            ActionBarAPI.sendActionBar(player, Main.prefix + "Please do not use hotkeys to move items.");
            event.setCancelled(true);
            return;
//      }else if(event.getAction() == InventoryAction.HOTBAR_SWAP || player.getOpenInventory().getType() == InventoryType.ENDER_CHEST)
//		{	
//        	if (KitsSelector.AllKits.) {
//            	player.sendMessage(Main.prefix + Main.color("&fYou can't put this item to ender chest"));
//    	        event.setCancelled(true);
//        	} else {
//        		event.setCancelled(false);
//        	}
//         }
	}
  }
}