package me.abdullah.pvp.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.utils.SetSpawnUtil;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		PlayerInventory pInv = p.getInventory();
		Location pLoc = p.getLocation();
		World world = p.getWorld();
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("setspawn") && p.hasPermission("pvp.setspawn"))
			{
				SetSpawnUtil.set(p);
				p.sendMessage(Main.prefix + Main.color("&e&lDone Save the Spawn location."));
					} else if (!p.hasPermission("pvp.setspawn")){					
						p.sendMessage(Main.prefix + Main.color("&cYou don't have permission"));
					}
				}
		return true;
  }
}
