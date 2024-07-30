package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.ranksup.RankAPI;
public class PVPStatics 
implements CommandExecutor
{
    public boolean onCommand(CommandSender Sender, Command Cmd, String Alias, String[] Args) {
        if (Sender instanceof Player) {
            Player p = (Player)Sender;
            if (Cmd.getName().equalsIgnoreCase("Records") || Cmd.getName().equalsIgnoreCase("Stats")) {
                if (Args.length > 1 || Args.length < 1) {
                    p.sendMessage("");
                    p.sendMessage(Main.prefix + ("§7Playername §8» " + RankAPI.getPlayerName(p)));
                    p.sendMessage(Main.prefix + ("§7Top §8» §e" + PVPStats.getRanking(p.getName())));
                    p.sendMessage(Main.prefix + ("§7Rank §8» " + RankAPI.getRank(p)));
                    p.sendMessage(Main.prefix + ("§7Points §8» §e" + PVPStats.getPoints(p.getName())));
                    p.sendMessage(Main.prefix + ("§7Kills §8» §e" + PVPStats.getKills(p.getName())));
                    p.sendMessage(Main.prefix + ("§7Deaths §8» §e" + PVPStats.getDeaths(p.getName())));
                    p.sendMessage(Main.prefix + ("§7K/D §8» §e" + PVPStats.getKD(p.getName())));
                    p.sendMessage("");
                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 100.0f, 100.0f);
                    return true;
                }
                if (Args.length == 1) {
                    String Playername = Args[0];
                    Player pp = Bukkit.getPlayer(Playername);
                    if (PVPStats.playerExists(Playername)) {
                        p.sendMessage("");
                        p.sendMessage(Main.prefix + ("§7Playername §8» " + RankAPI.getPlayerName(pp)));
                        p.sendMessage(Main.prefix + ("§7Top §8» §e" + PVPStats.getRanking(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Rank §8» " + RankAPI.getRank(pp)));
                        p.sendMessage(Main.prefix + ("§7Points §8» §e" + PVPStats.getPoints(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Kills §8» §e" + PVPStats.getKills(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Deaths §8» §e" + PVPStats.getDeaths(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7K/D §8» §e" + PVPStats.getKD(pp.getName())));
                        p.sendMessage("");
                        return false;
                    }
                    else {
                        p.sendMessage("");
                        p.sendMessage(Main.prefix + ("§7Playername §8» " + RankAPI.getPlayerName(pp)));
                        p.sendMessage(Main.prefix + ("§7Top §8» §e" + PVPStats.getRanking(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Rank §8» " + RankAPI.getRank(pp)));
                        p.sendMessage(Main.prefix + ("§7Points §8» §e" + PVPStats.getPoints(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Kills §8» §e" + PVPStats.getKills(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7Deaths §8» §e" + PVPStats.getDeaths(pp.getName())));
                        p.sendMessage(Main.prefix + ("§7K/D §8» §e" + PVPStats.getKD(pp.getName())));
                        p.sendMessage("");
                    }
                }
            }
            return true;
        }
        return false;
    }
}
