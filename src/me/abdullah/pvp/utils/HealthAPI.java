package me.abdullah.pvp.utils;

import org.bukkit.entity.Player;

public class HealthAPI 
{
	  public static String getHealthLeft(Player p)
	  {
		if (p.getHealth() >= 20) {
	      return "§e§l❤❤❤❤❤❤❤❤❤❤";
	    }
		
		if ((p.getHealth() >= 19) && (p.getHealth() <= 19.9)) {
		      return "§e§l❤❤❤❤❤❤❤❤❤❥";
		}
		
		if ((p.getHealth() >= 18) && (p.getHealth() <= 18.9)) {
		      return "§e§l❤❤❤❤❤❤❤❤❤§7❤";
		}
		
		if ((p.getHealth() >= 17) && (p.getHealth() <= 17.9)) {
		      return "§e§l❤❤❤❤❤❤❤❤❥§7❤";
		}
		
		if ((p.getHealth() >= 16) && (p.getHealth() <= 16.9)) {
		      return "§e§l❤❤❤❤❤❤❤❤§7❤❤";
		}
		
		if ((p.getHealth() >= 15) && (p.getHealth() <= 15.9)) {
		      return "§e§l❤❤❤❤❤❤❤❥§7❤❤";
		}
		
		if ((p.getHealth() >= 14) && (p.getHealth() <= 14.9)) {
		      return "§e§l❤❤❤❤❤❤❤§7❤❤❤";
		}
		
		if ((p.getHealth() >= 13) && (p.getHealth() <= 13.9)) {
		      return "§e§l❤❤❤❤❤❤❥§7❤❤❤";
		}
		
		if ((p.getHealth() >= 12) && (p.getHealth() <= 12.9)) {
		      return "§e§l❤❤❤❤❤❤§7❤❤❤❤";
		}
		
		if ((p.getHealth() >= 11) && (p.getHealth() <= 11.9)) {
		      return "§e§l❤❤❤❤❤❥§7❤❤❤❤";
		}
		
		if ((p.getHealth() >= 10) && (p.getHealth() <= 10.9)) {
		      return "§e§l❤❤❤❤❤§7❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 9) && (p.getHealth() <= 9.9)) {
		      return "§e§l❤❤❤❤❥§7❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 8) && (p.getHealth() <= 8.9)) {
		      return "§e§l❤❤❤❤§7❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 7) && (p.getHealth() <= 7.9)) {
		      return "§e§l❤❤❤❥§7❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 6) && (p.getHealth() <= 6.9)) {
		      return "§e§l❤❤❤§7❤❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 5) && (p.getHealth() <= 5.9)) {
		      return "§e§l❤❤❥§7❤❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 4) && (p.getHealth() <= 4.9)) {
		      return "§e§l❤❤§7❤❤❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 3) && (p.getHealth() <= 3.9)) {
		      return "§e§l❤❥§7❤❤❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 2) && (p.getHealth() <= 2.9)) {
		      return "§e§l❤§7❤❤❤❤❤❤❤❤❤";
		}
		
		if (p.getHealth() >= 1) {
		      return "§e§l❥§7❤❤❤❤❤❤❤❤❤";
		}
		
		if ((p.getHealth() >= 0) && (p.getHealth() <= 0.9)) {
		      return "§7❤❤❤❤❤❤❤❤❤❤";
		}
		
	    return null;
	  }
}
