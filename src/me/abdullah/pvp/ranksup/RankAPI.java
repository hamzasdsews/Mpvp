	package me.abdullah.pvp.ranksup;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
public class RankAPI 
{
    public static LuckPerms api = LuckPermsProvider.get();

	public static String getRank(Player p)
	{
		String msg = "100";
		int kills = PVPStats.getKills(p.getName());
		if (kills == 0) {
		msg = Main.F("&7Bronze");
		}
		if (kills >= 1) {
	    msg = Main.F("&7Bronze");
		}
		if (kills == 100) {
		    msg = Main.F("&aWarrior");
		}
		if (kills >= 100) {
		    msg = Main.F("&aWarrior");
		}
		if (kills == 300) {
		    msg = Main.F("&3Power");
		}
		if (kills >= 300) {
		    msg = Main.F("&3Power");
		}
		if (kills == 700) {
		    msg = Main.F("&eSuper");
		}
		if (kills >= 700) {
		    msg = Main.F("&eSuper");
		}
		if (kills == 900) {
		    msg = Main.F("&5Crystal");
		}
		if (kills >= 900) {
		    msg = Main.F("&5Crystal");
		}
		if (kills == 1200) {
		    msg = Main.F("&b&lChampion");
		}
		if (kills >= 1200) {
		    msg = Main.F("&b&lChampion");
		}
		if (kills == 2400) {
		    msg = Main.F("&c&lMaster");
		}
		if (kills >= 2400) {
		    msg = Main.F("&c&lMaster");
		}
		if (kills == 4800) {
		    msg = Main.F("&e&lNaary");
		}
		if (kills >= 4800) {
		    msg = Main.F("&e&lNa&6&la&e&lry");
		} else {
			msg = Main.F("&7Bronze");	
		}
		return msg;
		
	}        
	public static String getKillerName(Player p)
	{
		Player k = p.getKiller();
    	String msg = "§7" + k.getName();
        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
        	msg = "§e" + k.getName();	    		
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("CoOwner")) {
        	msg = "§bCO §7┃ §e" + k.getName();	    		
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
        	msg = "§1" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
        	msg = "§0" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
        	msg = "§4Head §7┃ §4" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
        	msg = "§4" + k.getName();		
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
        	msg = "§4Sr §7┃ §c" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
        	msg = "§c" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
        	msg = "§3" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
        	msg = "§d" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
        	msg = "§f" + k.getName();		
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
        	msg = "§6" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
        	msg = "§b" + k.getName();	
    	}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
        	msg = "§a" + k.getName();	
    	}
    	else  {
    	    msg = "§9" + k.getName();	
    	}
    	return msg;
	}
	 public static String getOfflinePlayer(OfflinePlayer offline) {
	    	String msg = "§7" + offline.getName();
	        if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
	        	msg = "§e" + offline.getName();   		
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("CoOwner")) {
	        	msg = "§e" + offline.getName();	    		
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
	        	msg = "§1" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
	        	msg = "§0" + offline.getName();	
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
	        	msg = "§4§l" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
	        	msg = "§4" + offline.getName();	
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
	        	msg = "§c" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
	        	msg = "§c" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
	        	msg = "§3" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
	        	msg = "§d" + offline.getName();	
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
	        	msg = "§f" + offline.getName();	
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
	        	msg = "§6" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
	        	msg = "§b" + offline.getName();
	    	}
	        else if (api.getUserManager().getUser(offline.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
	        	msg = "§a" + offline.getName();
	    	}
	    	else  {
	    	    msg = "§9" + offline.getName();
	    	}
	    	return msg;
		}
	  public static String getPlayerName(Player p) {
	    	String msg = "§7" + p.getName();
	        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
	        	msg = "§e" + p.getName();   		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("CoOwner")) {
	        	msg = "§e" + p.getName();	    		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
	        	msg = "§1" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
	        	msg = "§0" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
	        	msg = "§4§l" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
	        	msg = "§4" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
	        	msg = "§c" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
	        	msg = "§c" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
	        	msg = "§3" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
	        	msg = "§d" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
	        	msg = "§f" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
	        	msg = "§6" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
	        	msg = "§b" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
	        	msg = "§a" + p.getName();
	    	}
	    	else  {
	    	    msg = "§9" + p.getName();
	    	}
	    	return msg;
		}
	  public static String getOutPlayerName(String string, Player p) {
	    	String msg = "§7" + p.getName();
	        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
	        	msg = "§e" + p.getName();   		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("CoOwner")) {
	        	msg = "§e" + p.getName();	    		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
	        	msg = "§1" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
	        	msg = "§0" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
	        	msg = "§4§l" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
	        	msg = "§4" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
	        	msg = "§c" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
	        	msg = "§c" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
	        	msg = "§3" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
	        	msg = "§d" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
	        	msg = "§f" + p.getName();	
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
	        	msg = "§6" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
	        	msg = "§b" + p.getName();
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
	        	msg = "§a" + p.getName();
	    	}
	    	else  {
	    	    msg = "§9" + p.getName();
	    	}
	    	return msg;
		}
		public static String getRankPl(Player p)
		{
			String msg = "§7Member";
	        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
	        	msg = "§eOwner";	    		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("CoOwner")) {
	        	msg = "§8[§c§l2§e§lO§b§l2§a§lI§8]" + p.getName();	    		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
	        	msg = "§1Developer";	    		
	    	}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
		    msg = Main.F("&3Head§4Admin");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
			msg = Main.F("&0FBI");
		    }
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
		    msg = Main.F("&4Admin");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
		    msg = Main.F("&4Sr.&4Moderator");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
		    msg = Main.F("&cModerator");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
		    msg = Main.F("&3Builder");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
	   	    msg = Main.F("&dFriendly");
		    }
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
	   	    msg = Main.F("&fYou&cTuber &4❤");
		    }
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
			    msg = Main.F("&6KinG ⚔");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
			    msg = Main.F("&bMVP &3➳");
			}
	        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
			    msg = Main.F("&aVIP &e☣");
			}
			else {
			    msg = Main.F("&9Member");			
			}
			return msg;
		}
}
