package me.abdullah.pvp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;

import me.abdullah.pvp.a.main.Main;





public class PVPSQL
{
	private String HOST;
	private String DATABASE;
	private String USER;
	private String PASSWORD;
	  public static Connection con;

	  public PVPSQL(String host, String database, String user, String password)
	  {
	    this.HOST = "";
	    this.DATABASE = "";
	    this.USER = "";
	    this.PASSWORD = "";
	    this.HOST = host;
	    this.DATABASE = database;
	    this.USER = user;
	    this.PASSWORD = password;
	    connect();
	  }

	  public static boolean isConnected()
	  {
	    return con != null;
	  }

	  public static void connect() {
	    if (!isConnected())
	      try {
	        con = DriverManager.getConnection("jdbc:mysql://" + Main.plugin.getConfig().getString("PvPSQL.Host") + ":" + Main.plugin.getConfig().getString("PvPSQL.Port") + "/" + Main.plugin.getConfig().getString("PvPSQL.Database") + "?autoReconnect=true", Main.plugin.getConfig().getString("PvPSQL.Username"), Main.plugin.getConfig().getString("PvPSQL.Password"));
	        Bukkit.getConsoleSender().sendMessage(Main.prefix + Main.color("&aPvPSQL Connected!"));
	      }
	      catch (SQLException e) {
	        Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cPvPSQL Connection failed!");
	      }
	  }

	  public static void disconnect()
	  {
	    try {
	      con.close();
	      Bukkit.getConsoleSender().sendMessage(Main.prefix + "§aPvPSQL Disconnected!");
	    }
	    catch (SQLException e) {
	      Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cPvPSQL Disconnected failed!");
	    }
	  }

	  public static PreparedStatement getStatement(String sql) {
	    if (isConnected()) {
	      try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        return ps;
	      }
	      catch (SQLException e) {
	      }
	    }
	    return null;
	  }
	  public static Connection getConnection()
	  {
	    return con;
	  }
	  public static ResultSet query(String qry) {
	    ResultSet rs = null;
	    try {
	      Statement st = con.createStatement();
	      rs = st.executeQuery(qry);
	    }
	    catch (SQLException e) {
	    }
	    return rs;
	  }

	  public static void closeStatement(Statement st) {
	    if (st != null)
	      try {
	        st.close();
	      }
	      catch (Exception e) {
	      }
	  }

	  public static void update(String qry)
	  {
	    Statement st = null;
	    try {
	      st = con.createStatement();
	      st.executeUpdate(qry);
	    }
	    catch (Exception e) {
	      connect();
	    }
	    closeStatement(st);
	  }

	  public static ResultSet getResult(String sql) {
	    if (isConnected()) {
	      try {
	        PreparedStatement ps = getStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        return rs;
	      }
	      catch (SQLException e) {
	      }
	    }
	    return null;
	  }
	}