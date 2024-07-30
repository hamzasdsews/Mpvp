package me.abdullah.pvp.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naarmc.mysql.api.FireWorkAPI;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PVPStats
{
	  public static void createTable()
	  {
	    try
	    {
	          PreparedStatement ps = PVPSQL.getStatement("CREATE TABLE IF NOT EXISTS PVP (Playername VARCHAR(100), UUID VARCHAR(100), Points INT(100), Kills(100), Deaths(100))");

	      ps.executeUpdate();
	    }
	    catch (Exception ex) {
	    }
	  }

	  public static boolean playerExists(String name) {
	    try {
	      ResultSet rs = PVPSQL.query("SELECT * FROM PVP WHERE Playername= '" + name + "'");
	      return (rs.next()) && (rs.getString("UUID") != null);
	    }
	    catch (SQLException e) {
	    }return Boolean.valueOf(false).booleanValue();
	  }

	  public static void register(Player p)
	  { 
	    try {
	      if (!playerExists(p.getName())) {
	        PreparedStatement ps = PVPSQL.getStatement("INSERT INTO PVP (Playername, UUID, Points, Kills, Deaths");
	        ps.setString(1, p.getName());
	        ps.setString(2, p.getUniqueId().toString());
	        ps.setInt(3, 1000);
	        ps.setInt(4, 0); // Kills
	        ps.setInt(5, 0); // Deaths
	        ps.executeUpdate();
	        ps.close();
	      }
	    }
	    catch (Exception ex) {
	    }
	  }
	  public static int getPoints(Player p) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p.getName());
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Points");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static int getPoints(String p)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p);
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Points");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static void setPoints(Player p, int c)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Points= ? WHERE Playername= ?");
		      ps.setInt(1, c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void addPoints(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Points= ? WHERE Playername= ?");
		      ps.setInt(1, getPoints(p) + c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void removePoints(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Points= ? WHERE Playername= ?");
		      ps.setInt(1, getPoints(p) - c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }
		  
		  
		  
		  
		  
		  
		  
	

		  public static int getKills(Player p) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p.getName());
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Kills");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static int getKills(String p)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p);
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Kills");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static void setKills(Player p, int c)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Kills= ? WHERE Playername= ?");
		      ps.setInt(1, c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void addKills(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Kills= ? WHERE Playername= ?");
		      ps.setInt(1, getKills(p) + c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void removeKills(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Kills= ? WHERE Playername= ?");
		      ps.setInt(1, getKills(p) - c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }
		  
		  
		  
		  
		  

		  public static int getDeaths(Player p) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p.getName());
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Deaths");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static int getDeaths(String p)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("SELECT * FROM PVP WHERE Playername= ?");
		      ps.setString(1, p);
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      int c = rs.getInt("Deaths");
		      rs.close();
		      ps.close();
		      return c;
		    }
		    catch (Exception ex) {
		    }return 0;
		  }

		  public static void setDeaths(Player p, int c)
		  {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Deaths= ? WHERE Playername= ?");
		      ps.setInt(1, c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void addDeaths(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Deaths= ? WHERE Playername= ?");
		      ps.setInt(1, getDeaths(p) + c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }

		  public static void removeDeaths(Player p, int c) {
		    try {
		      PreparedStatement ps = PVPSQL.getStatement("UPDATE PVP SET Deaths= ? WHERE Playername= ?");
		      ps.setInt(1, getDeaths(p) - c);
		      ps.setString(2, p.getName());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (Exception ex) {
		    }
		  }
		  
	  public static double round(double D, int C) {
	    double P = Math.pow(10.0D, C);
	    return Math.round(D * P) / P;
	  }

	  public static float getKD(String Playername) {
	    float Kills = getKills(Playername);
	    float Deaths = getDeaths(Playername);
	    if ((Kills == 0.0F) && (Deaths == 0.0F)) {
	      return 0.0F;
	    }
	    if ((Kills > 0.0F) && (Deaths == 0.0F)) {
	      return Kills;
	    }
	    if ((Deaths > 0.0F) && (Kills == 0.0F)) {
	      return 0.0F;
	    }
	    if (Kills / Deaths > 0.0001D) {
	      Math.round(0.1D);
	      return (float)round(Kills / Deaths, 2);
	    }
	    if (Kills > Deaths) {
	      return Kills / Deaths;
	    }
	    if (Deaths / Kills > 0.0001D) {
	      Math.round(0.1D);
	      return (float)round(Deaths / Kills, 2);
	    }
	    if (Deaths > Kills) {
	      return Deaths / Kills;
	    }
	    return Kills / Deaths;
	  }

	 
	  
	public static void getK(Player p, Integer i)
	  {
	    ArrayList<String> uuid = new ArrayList<String>();
	    ResultSet rs = PVPSQL.getResult("SELECT * FROM PVP ORDER BY Kills DESC LIMIT " + i);
	    try
	    {
	      while (rs.next())
	        uuid.add(rs.getString("Playername"));
	    }
	    catch (SQLException localSQLException) {
	    }
	    Integer PlayerID = Integer.valueOf(0);
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lKills §8§l]§8§m-------------");
	    for (int i2 = 0; i2 <= uuid.size() - 1; i2++)
	    {
	      PlayerID = Integer.valueOf(PlayerID.intValue() + 1);
	      p.sendMessage("§8» §c#" + PlayerID + " §3" + (String)uuid.get(i2) + " §8» §b" + getKills((String)uuid.get(i2)) + " §3Kills");
	    }
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lKills §8§l]§8§m-------------");
	  }

	  public static void getD(Player p, Integer i)
	  {
	    ArrayList<String> uuid = new ArrayList<String>();
	    ResultSet rs = PVPSQL.getResult("SELECT * FROM PVP ORDER BY Deaths DESC LIMIT " + i);
	    try
	    {
	      while (rs.next())
	        uuid.add(rs.getString("Playername"));
	    }
	    catch (SQLException localSQLException) {
	    }
	    Integer PlayerID = Integer.valueOf(0);
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lDeaths §8§l]§8§m-------------");
	    for (int i2 = 0; i2 <= uuid.size() - 1; i2++)
	    {
	      PlayerID = Integer.valueOf(PlayerID.intValue() + 1);
	      p.sendMessage("§8» §c#" + PlayerID + " §3" + (String)uuid.get(i2) + " §8» §b" + getDeaths((String)uuid.get(i2)) + " §3Deaths");
	    }
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lDeaths §8§l]§8§m-------------");
	  }
	  
	  public static void getP(Player p, Integer i)
	  {
	    ArrayList<String> uuid = new ArrayList<String>();
	    ResultSet rs = PVPSQL.getResult("SELECT * FROM PVP ORDER BY Points DESC LIMIT " + i);
	    try
	    {
	      while (rs.next())
	        uuid.add(rs.getString("Playername"));
	    }
	    catch (SQLException localSQLException) {
	    }
	    Integer PlayerID = Integer.valueOf(0);
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lPoints §8§l]§8§m-------------");
	    for (int i2 = 0; i2 <= uuid.size() - 1; i2++)
	    {
	      PlayerID = Integer.valueOf(PlayerID.intValue() + 1);
	      p.sendMessage("§8» §c#" + PlayerID + " §3" + (String)uuid.get(i2) + " §8» §b" + getPoints((String)uuid.get(i2)) + " §3Points");
	    }
	    p.sendMessage("§8§m------------§r§8§l[ §3§lTop §c⚔ §b§lPoints §8§l]§8§m-------------");
	  }
	  
	  
	  public static int getRanking(String Playername) {
		    int Ranking = 1;
		    ResultSet Result = PVPSQL.getResult("SELECT * FROM PVP ORDER BY Kills desc");
		    try {
		      while (Result.next()) {
		        if (Result.getString("Playername").equalsIgnoreCase(Playername)) {
		          return Ranking;
		        }
		        Ranking++;
		      }
		    } catch (SQLException localSQLException) {
		    }
		    return Ranking;
		  }
}