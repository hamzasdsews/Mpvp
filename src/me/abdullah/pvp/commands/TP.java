package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;
public class TP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		Player p = (Player)sender;
		if (cmd.getName().equals("tp") && p.hasPermission("ffa.tp"))
		{
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				player.sendMessage(Main.prefix + Main.F("&cSyntax: /tp <playername>"));
			} else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				player.sendMessage(Main.prefix + Main.F("&cYou have been teleport to &e" + target.getName()));
				player.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.9f, 0.9f);
                try {				
                	player.teleport(target.getLocation());
                }catch (NullPointerException e) {
                	  player.sendMessage(Main.prefix + Main.F("&aPlayer does not exist."));
                }
			} else if(args.length == 2) {
				Player playerToSend = Bukkit.getPlayer(args[0]);
				Player target = Bukkit.getPlayer(args[1]);
				try {
					playerToSend.teleport(target.getLocation());
				} catch (NullPointerException e) {
              	  player.sendMessage(Main.prefix + Main.F(""));
				}
			} else {
	        	 p.sendMessage(Main.prefix + Main.F("&cYou don't have permissions"));
	             p.playSound(p.getLocation(), Sound.ITEM_BREAK, 2.0f, 2.0f);				
			}
			
		}
		return true;
	}
		return true;

  }
	
}
