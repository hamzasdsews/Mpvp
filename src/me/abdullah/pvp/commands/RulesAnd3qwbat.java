package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import me.abdullah.pvp.a.main.Main;

public class RulesAnd3qwbat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rules")) {
			Player p = (Player)sender;
			Rules(p);
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 100.0f, 100.0f);
		}
		return false;
	}
	
	
	
	public static Inventory Rules(Player p) {
		Inventory i = Bukkit.createInventory(null, 45, Main.color("&5➤ Rules"));
		i.setItem(10, Stackat.Num1(p));
		i.setItem(12, Stackat.Num2(p));
		i.setItem(14, Stackat.Num3(p));
		i.setItem(16, Stackat.Num4(p));
		i.setItem(28, Stackat.Num5(p));
		i.setItem(30, Stackat.Num6(p));
		i.setItem(32, Stackat.Num7(p));
		i.setItem(34, Stackat.Num8(p));
		i.setItem(40, Stackat.Next(p));
		p.openInventory(i);
		return i;
	}
	public static Inventory qwbat(Player p) {
		Inventory i = Bukkit.createInventory(null, 54, Main.color("&5➤ 3QWBAT"));
		i.setItem(10, Stackat.Hacking(p));
		i.setItem(12, Stackat.Fly(p));
		i.setItem(14, Stackat.SwearingStaff(p));
		i.setItem(16, Stackat.SwearingOwner(p));
		i.setItem(28, Stackat.SwearingServer(p));
		i.setItem(30, Stackat.Spamming(p));
		i.setItem(32, Stackat.AbuseReport(p));
		i.setItem(34, Stackat.AbuseGlitch(p));
		i.setItem(38, Stackat.Caps(p));
		i.setItem(42, Stackat.Adveristing(p));
		i.setItem(49, Stackat.PreviusPage(p));
		p.openInventory(i);
		return i;
	}
}
