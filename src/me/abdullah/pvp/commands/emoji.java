package me.abdullah.pvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;

public class emoji implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("emoji"))
		{
			p.sendMessage(Main.prefix + Main.color("&c&m------&e&m------&a&m------&b&m------"));
			p.sendMessage(Main.prefix + Main.color("&3Available Emoji's :- "));
			p.sendMessage(Main.prefix + Main.color("&e:star: &8- &6✮"));
			p.sendMessage(Main.prefix + Main.color("&e:shrug: &8-" + " &f¯\\_(ツ)_/¯"));
			p.sendMessage(Main.prefix + Main.color("&e:tableflip: &8- &f(╯°□°）╯︵ ┻━┻"));
			p.sendMessage(Main.prefix + Main.color("&eo/ &8-" + " &f\u00a7d( \uff9f\u25e1\uff9f)/\u00a7r"));
			p.sendMessage(Main.prefix + Main.color("&f<3 &8- &c❤"));
			p.sendMessage(Main.prefix + Main.color("&c&m------&e&m------&a&m------&b&m------"));
		}
		  // o/
		return false;
	}

}
