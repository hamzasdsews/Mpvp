package me.abdullah.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.ranksup.RankAPI;
import me.abdullah.pvp.utils.BoardAPI;
import net.minecraft.server.v1_8_R3.EntityLightning;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedSoundEffect;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather;

public class ResetStats implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
        if (cmd.getName().equalsIgnoreCase("resetstats"));
         Player p = (Player)sender;
         if (args.length == 0)
         {
             p.sendMessage(Main.prefix + Main.color("&bSyntax: /resetstats <playername>"));        	 
         } 
         if (args.length == 1)
         {
        	 OfflinePlayer Offline = Bukkit.getOfflinePlayer(args[0]);
        	 for (Player target : Bukkit.getOnlinePlayers())
        	 {
        	 if (args[0].equalsIgnoreCase(target.getName()))
        	 {
        if (target.isOnline()) {
        	PVPStats.setKills(target, 1);
        	PVPStats.setDeaths(target, 1);
        	PVPStats.setPoints(target, 1000);
        	p.sendMessage(Main.prefix + Main.color(RankAPI.getPlayerName(target) + "'s &bStats &7has been reset"));
        	p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0f, 1.0f);
        	BoardAPI.onScoreboard(p);
        	BoardAPI.onScoreboard(target);
        	((CraftPlayer) (target)).getHandle().playerConnection.sendPacket(new PacketPlayOutSpawnEntityWeather(new EntityLightning(((CraftPlayer) (target)).getHandle().getWorld(), ((target)).getLocation().getX(), ((target)).getLocation().getY(), ((target)).getLocation().getZ(), false, false)));
        	((CraftPlayer) (target)).getHandle().playerConnection.sendPacket(new PacketPlayOutNamedSoundEffect("ambient.weather.thunder", ((target)).getLocation().getX(), ((target)).getLocation().getY(), ((target)).getLocation().getZ(), 10000.0F, 63));
        	target.getWorld().strikeLightning(target.getLocation().add(0,0,5));
        	target.playSound(target.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);
        	Bukkit.broadcastMessage(Main.prefix + Main.color(RankAPI.getPlayerName(target) + "'s &bStats &7has been reset")); 
        	} else if (Offline == null)
        	{
            	PVPStats.setKills(target, 1);
            	PVPStats.setDeaths(target, 1);
            	PVPStats.setPoints(target, 1000);
            	
            	p.sendMessage(Main.prefix + Main.color(RankAPI.getOfflinePlayer(Offline) + "'s &bStats &7has been reset"));
            	p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0f, 1.0f);
        	}
        }
      }
    }
 return true;
      }
 }