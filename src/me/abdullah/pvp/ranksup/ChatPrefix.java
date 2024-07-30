package me.abdullah.pvp.ranksup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.PlayersSettings;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;


public class ChatPrefix implements Listener{
    static LuckPerms api = LuckPermsProvider.get();
    @EventHandler
    public void PlayerAsyncChatShars(AsyncPlayerChatEvent e) {
        String message;
        if (e.getPlayer().hasPermission("chatexpressions.useall")) {
            message = e.getMessage();
            message = message.replace("<3", "\u00a7c\u2764\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace(":star:", "\u00a76\u272e\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace(":shrug:", "\u00a7e\u00af\\_(\u30c4)_/\u00af\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace(":tableflip:", "\u00a7c(\u256f\u00b0\u25a1\u00b0\uff09\u256f\u00a7f\ufe35 \u00a77\u253b\u2501\u253b\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace("o/", "\u00a7d( \uff9f\u25e1\uff9f)/\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace(":123:", "\u00a7a1\u00a7e2\u00a7c3\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            message = message.replace(":totem:", "\u00a7b\u2609\u00a7e_\u00a7b\u2609\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.heart")) {
            message = e.getMessage();
            message = message.replace("<3", "\u00a7c\u2764\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.star")) {
            message = e.getMessage();
            message = message.replace(":star:", "\u00a76\u272e\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.shrug")) {
            message = e.getMessage();
            message = message.replace(":shrug:", "\u00a7e\u00af\\_(\u30c4)_/\u00af\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.tableflip")) {
            message = e.getMessage();
            message = message.replace(":tableflip:", "\u00a7c(\u256f\u00b0\u25a1\u00b0\uff09\u256f\u00a7f\ufe35 \u00a77\u253b\u2501\u253b\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.highfive")) {
            message = e.getMessage();
            message = message.replace("o/", "\u00a7d( \uff9f\u25e1\uff9f)/\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.123")) {
            message = e.getMessage();
            message = message.replace(":123:", "\u00a7a1\u00a7e2\u00a7c3\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
        if (e.getPlayer().hasPermission("chatexpressions.use.totem")) {
            message = e.getMessage();
            message = message.replace(":totem:", "\u00a7b\u2609\u00a7e_\u00a7b\u2609\u00a7r" + ChatColor.translateAlternateColorCodes('§', Main.plugin.getConfig().getString("afteremojimessagecolor")));
            e.setMessage(message);
        }
    }
    @EventHandler 
    public void onPlayer(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if (PlayersSettings.getscramble(p.getName()) == 1)
        {
        	e.setFormat("§e# §8§l▏ " + RankAPI.getPlayerName(p) + " §8» §f" + msg);
        } else {
            if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
             	e.setFormat(RankAPI.getRank(p) + " §8▏ §e" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                    all.playSound(all.getLocation(), Sound.CLICK, 5.4f, 34.0f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("coowner")) {
             	e.setFormat(RankAPI.getRank(p) + " §8▏ " + "§bCo §eOwner §e" + p.getName() + " §8» §f" + msg);    		
        	}
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
        	    e.setFormat(RankAPI.getRank(p) + " §8▏ §1" + p.getName() + " §8» §f" + msg);
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §4Head §7▎ §4" + p.getName() + " §8» §f" + msg);
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("fbi")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §0" + p.getName() + " §8» §f" + msg);
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §4" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                    all.playSound(all.getLocation(), Sound.CLICK, 5.4f, 34.0f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §4Sr §7▎ §c" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                    all.playSound(all.getLocation(), Sound.CLICK, 5.4f, 34.0f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §c" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                    all.playSound(all.getLocation(), Sound.CLICK, 5.4f, 34.0f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
            	e.setFormat(RankAPI.getRank(p) + " §8▏ §3" + p.getName() + " §8» §f" + msg);
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
                e.setFormat(RankAPI.getRank(p) + " §8▏ §d" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                	all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
                e.setFormat(RankAPI.getRank(p) + " §8▏ §f" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                	all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
                e.setFormat(RankAPI.getRank(p) + " §8▏ §a" + p.getName() + " §8» §f" + msg);
                for (Player all : Bukkit.getOnlinePlayers())
                {
                	all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
                }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
                 e.setFormat(RankAPI.getRank(p) + " §8▏ §b" + p.getName() + " §8» §f" + msg);
                 for (Player all : Bukkit.getOnlinePlayers())
                 {
                 	all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
                 }
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
                 e.setFormat(RankAPI.getRank(p) + " §8▏ §6" + p.getName() + " §8» §f" + msg);
            }
            else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("default")) {
                 e.setFormat(RankAPI.getRank(p) + " §8▏ §9" + p.getName() + " §8» §f" + msg);
            }
          }
        }

    @EventHandler
    public void onPlayer(PlayerChatEvent e) {
        if (e.getMessage().contains("%")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayer2(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("chatcolor")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        }
    } 
    
    @EventHandler
    public void onPreprocess(PlayerCommandPreprocessEvent e) {
      Player P = e.getPlayer();
      String msg = e.getMessage();
      if (msg.startsWith("/pl") || msg.startsWith("/plugins") || msg.startsWith("/?") || msg.startsWith("bukkit:pl") || msg.startsWith("bukkit:plugins") || msg.startsWith("bukkit:?")) {
        e.setCancelled(true);
        P.sendMessage(Main.prefix + "§cIllegal command.");
      }
    }
 }
