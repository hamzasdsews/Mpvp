package me.abdullah.pvp.ranksup;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;

public class CMDRanks implements CommandExecutor{
	public static String Next(Player p)
	{
		String msg = "§7Bronze";
		int k = PVPStats.getKills(p.getName());
		if (k >= 0)
		{
			msg = "§aWarrior";
		}
		if (k >= 100)
		{
			msg = "§3Power";
		}
		if (k >= 300)
		{
			msg = "§eSuper";
		}
		if (k >= 700)
		{
			msg = "§5Crystal";
		}
		if (k >= 900)
		{
			msg = "§b§lChampion";
		}
		if (k >= 1200)
		{
			msg = "§c§lMaster";
		}
		if (k >= 2400)
		{
			msg = "§e§lNa§6§la§e§lry";
		}
		if (k >= 4800)
		{
			msg = "§eYou are in the last rank GG, !";
		}
		return msg;
	}
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("ps")) {
			p.sendMessage(Main.prefix + Main.color("&8--------------------"));
			p.sendMessage(Main.prefix + Main.color("&7Bronze &8▸ &f0 kills."));
			p.sendMessage(Main.prefix + Main.color("&aWarrior &8▸ &f100 kills."));
			p.sendMessage(Main.prefix + Main.color("&3Power &8▸ &f300 kills."));
			p.sendMessage(Main.prefix + Main.color("&eSuper &8▸ &f700 kills."));
			p.sendMessage(Main.prefix + Main.color("&5Crystal &8▸ &f900 kills."));
			p.sendMessage(Main.prefix + Main.color("&b&lChampion &8▸ &f1200 kills."));
			p.sendMessage(Main.prefix + Main.color("&c&lMaster &8▸ &f2400 kills."));
			p.sendMessage(Main.prefix + Main.color("&e&lNa&6&la&e&lry &8▸ &f4800 kills."));
			p.sendMessage(Main.prefix + Main.color("&8--------------------"));
			p.sendMessage(Main.prefix + Main.color("&b&lNext Rank &8▸ " + Next(p)));
			p.sendMessage(Main.prefix + Main.color("&8--------------------"));
		} 
		return true;
	}

}