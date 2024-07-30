package me.abdullah.pvp.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.utils.SetSpawnUtil;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if (sender instanceof Player)
		{
			World w = p.getWorld();
			if (cmd.getName().equalsIgnoreCase("spawn"))
			{	
				SetSpawnUtil.teleport(p);
			}
		}
		return true;
   }
}
