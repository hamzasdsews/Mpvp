/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Server
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.command.PluginCommand
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Player$Spigot
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntitySpawnEvent
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.event.player.PlayerChatEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.PluginDescriptionFile
 *  org.bukkit.plugin.PluginManager
 *  org.bukkit.plugin.java.JavaPlugin
 *  org.bukkit.scheduler.BukkitScheduler
 */
package me.abdullah.pvp.a.main;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import me.abdullah.pvp.commands.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import com.naarmc.mysql.api.TabAPI;

import me.abdullah.pvp.Listeners.DeathEvent;
import me.abdullah.pvp.Listeners.Events;
import me.abdullah.pvp.Listeners.TrailsEvents;
import me.abdullah.pvp.api.FlintAPI;
import me.abdullah.pvp.api.HologramsAPI;
import me.abdullah.pvp.api.PingAPI;
import me.abdullah.pvp.apiBars.ActionBarsAPI;
import me.abdullah.pvp.combat.CombatEvents;
import me.abdullah.pvp.combat.CombatTimer;
import me.abdullah.pvp.holograms.RanksHologram;
import me.abdullah.pvp.holograms.ShopWarnHologram;
import me.abdullah.pvp.holograms.TopHologram;
import me.abdullah.pvp.modes.Settings;
import me.abdullah.pvp.modes.Spectator;
import me.abdullah.pvp.modes.SpectatorDamage;
import me.abdullah.pvp.mysql.PVPSQL;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.ranksup.CMDRanks;
import me.abdullah.pvp.ranksup.ChatPrefix;
//import me.abdullah.pvp.shop.ArrowTrails;
import me.abdullah.pvp.shop.CancellableItems;
import me.abdullah.pvp.shop.ClickInventory;
import me.abdullah.pvp.shop.DefaultKits;
import me.abdullah.pvp.shop.InventoriesFix;
import me.abdullah.pvp.shop.ItemsNotPurched;
import me.abdullah.pvp.shop.ShopBattleCry;
import me.abdullah.pvp.shop.ShopItems;
import me.abdullah.pvp.shop.ShopTrails;
import me.abdullah.pvp.utils.ActionBarAPI;
import me.abdullah.pvp.utils.BoardAPI;
import me.abdullah.pvp.utils.EntityUtils;
import me.abdullah.pvp.utils.PendingVelocity;
import me.abdullah.pvp.utils.PlayersShop;
import me.abdullah.pvp.utils.SetSpawnUtil;
import net.minecraft.server.v1_8_R3.EntityLightning;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedSoundEffect;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather;
public class Main
extends JavaPlugin
implements Listener {
	
	BukkitScheduler respawn = getServer().getScheduler();
    public static ArrayList<Player> VIP = new ArrayList<Player>();
    public static ArrayList<Player> spectate = new ArrayList<Player>();
    public static ArrayList<String> InGamePlayers = new ArrayList<String>();
    private List<PendingVelocity> pendingVelocity;
    public static Map<Player, Double> horizontalMovement;
    public String serverVersion;
    public static List<String> blacklistedCommands;
    // ArrowTrails |
    //             v

    public static ArrayList<String> smoke = new ArrayList<String>();
    public static ArrayList<String> cantusesmoke = new ArrayList<String>();
    
    public static ArrayList<String> lavapop = new ArrayList<String>();
    public static ArrayList<String> cantuselavapop = new ArrayList<String>();
    // ArrowTrails .^^
    
	public static Map<String, Long> rewardtime = new HashMap<String, Long>();
    public static Main sharedInstance;
    private static Main instance;
    public static HashMap<String, ItemStack[]> kit = new HashMap<String, ItemStack[]>();
    public static String prefix = Main.color("&8&l▎ &e&lPVP &8▏ &f");
    public static Main plugin;
    public Main() {
        Main.sharedInstance = this;
    }
    public static Main sharedInstance() {
        return Main.sharedInstance;
    }
	public void onEnable() {

        plugin = this;
        

        
        instance = this;
        pendingVelocity = new CopyOnWriteArrayList<PendingVelocity>();
        blacklistedCommands = (List<String>) getConfig().getList("Settings.CommandBlacklist");
        serverVersion = Bukkit.getServer().getClass().getPackage().getName().substring(23);
        horizontalMovement = new WeakHashMap<Player, Double>();
        Bukkit.getConsoleSender().sendMessage(Main.F("&8[&e&lNaarMC_PVP&8] &ahas been enabled."));

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new TrailsEvents(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CombatTimer(), 20L, 20L);
        Bukkit.getPluginManager().registerEvents(new CombatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new InventoriesFix(), this);
        Bukkit.getPluginManager().registerEvents(new Stackat(), this);
        Bukkit.getPluginManager().registerEvents(new FlintAPI(), this);
        Bukkit.getPluginManager().registerEvents(new PingAPI(), this);
        Bukkit.getPluginManager().registerEvents(new Staff(), this);
        Bukkit.getPluginManager().registerEvents(new ChatPrefix(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new CancellableItems(), this);
        Bukkit.getPluginManager().registerEvents(new ClickInventory(), this);
        Bukkit.getPluginManager().registerEvents(new EntityUtils(), this);
        Bukkit.getPluginManager().registerEvents(new Spectator(), this);
        Bukkit.getPluginManager().registerEvents(new SpectatorDamage(), this);
        Bukkit.getPluginManager().registerEvents(new Settings(), this);
        Bukkit.getPluginManager().registerEvents(new ActionBarsAPI(), this);
        Bukkit.getPluginManager().registerEvents(new ItemsNotPurched(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginCommand("tp").setExecutor(new TP());

        getCommand("emoji").setExecutor(new emoji());
        getCommand("custom").setExecutor(new Custom());
        getCommand("rules").setExecutor(new RulesAnd3qwbat());
        getCommand("ffa").setExecutor(new PointsCMD());
        getCommand("addpoints").setExecutor(new PointsCMD());
        getCommand("removepoints").setExecutor(new PointsCMD());
        getCommand("resetstats").setExecutor(new ResetStats());
        getCommand("fly").setExecutor(new Fly());
        getCommand("staff").setExecutor(new Staff());
        getCommand("gm").setExecutor(new GameModes());
        getCommand("gamemode").setExecutor(new GameModes());
        getCommand("tpall").setExecutor(new tpall());
        getCommand("clear").setExecutor(new clear());
        getCommand("invsee").setExecutor(new invsee());
        getCommand("cc").setExecutor(new CC());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("ps").setExecutor(new CMDRanks());
        getCommand("stats").setExecutor(new PVPStatics());
        getCommand("records").setExecutor(new PVPStatics());
        PVPSQL.connect();
        PVPStats.createTable();

        
        for (Player all : Bukkit.getOnlinePlayers()) {
        	
        	ActionBarAPI.sendActionBar(all, prefix + "§3§lThe game has been reloaded!");
        	
            BoardAPI.onScoreboard(all);
            
            SetSpawnUtil.teleport(all);
            
            all.removePotionEffect(PotionEffectType.INVISIBILITY);
                        
    		Events.PVP.add(all);		
            
            HologramsAPI.all(all);
                        
        }
        
      
    }
        public static Inventory ShopDefault(Player p) {
        Inventory invshop = Bukkit.createInventory(null, 45, Main.color("PVP Shop"));
        invshop.setItem(11, ShopItems.Stats(p));
        invshop.setItem(13, Settings.OutItem(p));
        invshop.setItem(15, ShopItems.Purchase(p));
        invshop.setItem(28, ShopItems.Kits(p));
        invshop.setItem(30, ShopItems.ArrowTrails(p));
        invshop.setItem(32, ShopItems.BattleCry(p));
        invshop.setItem(34, ShopItems.Perks(p));
        p.openInventory(invshop);
        return invshop;
    } 
        public static Inventory Kits(Player p) {
            Inventory invkits = Bukkit.createInventory(null, 27,Main.color("Kits"));
            invkits.setItem(26, ShopItems.GB1(p));
            if (DefaultKits.api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
                invkits.setItem(11, DefaultKits.DefaultKitVIP(p));           	
            } else if (DefaultKits.api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
                invkits.setItem(11, DefaultKits.DefaultKitMVP(p));
            } else if (DefaultKits.api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
                invkits.setItem(11, DefaultKits.DefaultKitKING(p));           	
            } else if (DefaultKits.api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) { 
                invkits.setItem(11, DefaultKits.DefaultKitYT(p));           	
            } else {
                invkits.setItem(11, DefaultKits.DefaultKit(p));           	
            }
            invkits.setItem(13, ShopItems.GoldKit(p));
            invkits.setItem(15, ShopItems.DiamondKit(p));
            p.openInventory(invkits);
            return invkits;
        }
    public static Inventory BattleCry(Player p) {
        Inventory Battle = Bukkit.createInventory(null, 54,Main.color("Battle Cry"));
        
        if (p.hasPermission("battlecry.villagerdeath") && PlayersShop.getVillagerdeath(p) == 1) {
        Battle.setItem(12, ShopBattleCry.VillagerDeathYes());
     }else if (p.hasPermission("battlecry.villagerdeath") && PlayersShop.getVillagerdeath(p) == 2) {
        Battle.setItem(12, ShopBattleCry.VillagerDeathYes());
        } else {
        Battle.setItem(12, ShopBattleCry.VillagerDeathBattleCry());
        }
        
        if (p.hasPermission("battlecry.catmeow") && PlayersShop.getCatMeowdeath(p) == 1) {
        Battle.setItem(14, ShopBattleCry.CatMeowYes());
      }else  if (p.hasPermission("battlecry.catmeow") && PlayersShop.getCatMeowdeath(p) == 2) {
        Battle.setItem(14, ShopBattleCry.CatMeowYes());
        } else {
        Battle.setItem(14, ShopBattleCry.CatMeowBattleCry());
        }   
        
        if (p.hasPermission("battlecry.zombiedeath") && PlayersShop.getZombiedeath(p) == 1) {
        Battle.setItem(20, ShopBattleCry.ZombieDeathYes());
     }else if (p.hasPermission("battlecry.zombiedeath") && PlayersShop.getZombiedeath(p) == 2) {
        Battle.setItem(20, ShopBattleCry.ZombieDeathYes());
        } else {
        Battle.setItem(20, ShopBattleCry.ZombieDeathBattleCry());
        }
        
        if (p.hasPermission("battlecry.batdeath") && PlayersShop.getBatdeath(p) == 1) {
        Battle.setItem(22, ShopBattleCry.BatDeathYes());
      }else  if (p.hasPermission("battlecry.batdeath") && PlayersShop.getBatdeath(p) == 2) {
        Battle.setItem(22, ShopBattleCry.BatDeathYes());
        } else {
        Battle.setItem(22, ShopBattleCry.BatDeathBattleCry());
        }
        
        if (p.hasPermission("battlecry.wolfdeath") && PlayersShop.getWolfdeath(p) == 1) {
        Battle.setItem(24, ShopBattleCry.WolfDeathYes());
      }else  if (p.hasPermission("battlecry.wolfdeath") && PlayersShop.getWolfdeath(p) == 2) {
        Battle.setItem(24, ShopBattleCry.WolfDeathYes());
        } else {
        Battle.setItem(24, ShopBattleCry.WolfDeathBattleCry());
        }       
        
        if (p.hasPermission("battlecry.Fireworks") && PlayersShop.getFirework(p) == 1) {
        Battle.setItem(30, ShopBattleCry.FireworkYes());
      }else  if (p.hasPermission("battlecry.Fireworks") && PlayersShop.getCatMeowdeath(p) == 2) {
        Battle.setItem(30, ShopBattleCry.FireworkYes());
        } else {
        Battle.setItem(30, ShopBattleCry.FireworkBattleCry());
        }   
        
        if (p.hasPermission("battlecry.Explode") && PlayersShop.getFirework(p) == 1) {
        Battle.setItem(32, ShopBattleCry.ExplosionYes());
      }else  if (p.hasPermission("battlecry.Explode") && PlayersShop.getCatMeowdeath(p) == 2) {
        Battle.setItem(32, ShopBattleCry.ExplosionYes());
        } else {
        Battle.setItem(32, ShopBattleCry.ExplosionBattleCry());
        }           
        
        if (p.hasPermission("battlecry.Strike") && PlayersShop.getStrike(p) == 1) {
        Battle.setItem(40, ShopBattleCry.StrikeYes());
      }else  if (p.hasPermission("battlecry.Strike") && PlayersShop.getStrike(p) == 2) {
        Battle.setItem(40, ShopBattleCry.StrikeYes());
        } else {
        Battle.setItem(40, ShopBattleCry.StrikeBattleCry());
        }         
        
        Battle.setItem(53, ShopItems.GB1(p));
        p.openInventory(Battle);
        return Battle;
      }
    
    
    public static Inventory BattleCryFeature(Player p) {
        Inventory Battle = Bukkit.createInventory(null, 54,Main.color("Available Battle Cry"));
        Battle.setItem(53, ShopItems.GB1(p));
        
        if (p.hasPermission("battlecry.villagerdeath")) {
        Battle.setItem(12, ShopBattleCry.VillagerDeathClickable());
        } else {
        Battle.setItem(12, ItemsNotPurched.VillagerDeath(p));
        }
        
        if (p.hasPermission("battlecry.catmeow")) {
        Battle.setItem(14, ShopBattleCry.CatMeowClickable());
        } else {
        Battle.setItem(14, ItemsNotPurched.CatMeow(p));
        }
        
        if (p.hasPermission("battlecry.zombiedeath")) {
        Battle.setItem(20, ShopBattleCry.ZombieDeathClickable());
        } else {
        Battle.setItem(20, ItemsNotPurched.ZombieDeath(p));
        }
        
        if (p.hasPermission("battlecry.batdeath")) {
        Battle.setItem(22, ShopBattleCry.BatDeathClickable());
        } else {
        Battle.setItem(22, ItemsNotPurched.BatDeath(p));
        }
        
        if (p.hasPermission("battlecry.wolfdeath")) {
        Battle.setItem(24, ShopBattleCry.WolfDeathClickable());
        } else {
        Battle.setItem(24, ItemsNotPurched.WolfDeath(p));
        }
        
        if (p.hasPermission("battlecry.Fireworks")) {
        Battle.setItem(30, ShopBattleCry.FireworkClickable());
        } else {
        Battle.setItem(30, ItemsNotPurched.Fireworks(p));
        }
        if (p.hasPermission("battlecry.Explode")) {
        Battle.setItem(32, ShopBattleCry.ExplosionClickable());
        } else {
        Battle.setItem(32, ItemsNotPurched.Explosion(p));
        }
        
        if (p.hasPermission("battlecry.Strike")) {
        Battle.setItem(40, ShopBattleCry.StrikeClickable());
        } else {
        Battle.setItem(40, ItemsNotPurched.Strike(p));
        }
        p.openInventory(Battle);
        return Battle;
     }
    public static Inventory Perks(Player p) {
        Inventory invperks = Bukkit.createInventory(null, 27,Main.color("Perks"));
        invperks.setItem(26, ShopItems.GB1(p));
        invperks.setItem(10, ShopItems.ApplePerks(p));
        invperks.setItem(12, ShopItems.TnTPerks(p));
        invperks.setItem(14, ShopItems.CobwebPerks(p));
        invperks.setItem(16, ShopItems.Arrow(p));
        p.openInventory(invperks);
        return invperks;
    }
    public static Inventory Trails(Player p) {
        Inventory trails = Bukkit.createInventory(null, 27,Main.color("Trails"));
        trails.setItem(26, ShopItems.GB1(p));
        if (p.hasPermission("trails.heart")) {
        trails.setItem(11, ShopTrails.HeartTrailYes(p));
        } else {
        trails.setItem(11, ShopTrails.HeartTrail(p));
        }
        if (p.hasPermission("trails.smoke")) {
        trails.setItem(13, ShopTrails.SmokeTrailYes(p));
        } else {
        trails.setItem(13, ShopTrails.SmokeTrail(p));
        }
        if (p.hasPermission("trails.lavapop")) {
        trails.setItem(15, ShopTrails.LavaPoPTrailYes(p));
        } else {
        trails.setItem(15, ShopTrails.LavaPoPTrail(p));
        }
        p.openInventory(trails);
        return trails;
    }
    public static Inventory haveHeart(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Trail."));
        p1.setItem(0, ShopTrails.HeartTrailYes(p));
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopTrails.RemoveTrail(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p1.setItem(9, null);
        p1.setItem(18, null);
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveSmoke(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Trail."));
        p1.setItem(0, ShopTrails.SmokeTrailYes(p));
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopTrails.RemoveTrail(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p1.setItem(9, null);
        p1.setItem(18, null);
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveLavaPoP(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Trail."));
        p1.setItem(0, ShopTrails.LavaPoPTrailYes(p));
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopTrails.RemoveTrail(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p1.setItem(9, null);
        p1.setItem(18, null);
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory PurchedItems(Player p) {
        Inventory purchase = Bukkit.createInventory(null, 27,Main.color("Choose Feature"));
        purchase.setItem(26, ShopItems.GB1(p));
        purchase.setItem(0, ItemsNotPurched.Zynh(p));
        purchase.setItem(1, ItemsNotPurched.Zynh(p));
        purchase.setItem(2, ItemsNotPurched.Zynh(p));
        purchase.setItem(3, ItemsNotPurched.Zynh(p));
        purchase.setItem(4, ItemsNotPurched.Zynh(p));
        purchase.setItem(5, ItemsNotPurched.Zynh(p));
        purchase.setItem(6, ItemsNotPurched.Zynh(p));
        purchase.setItem(7, ItemsNotPurched.Zynh(p));
        purchase.setItem(8, ItemsNotPurched.Zynh(p));
        purchase.setItem(9, ItemsNotPurched.Zynh(p));
        purchase.setItem(12, ShopTrails.TrailsFeatures());
        purchase.setItem(14, ShopBattleCry.BattleCryOpenFeature());
        purchase.setItem(17, ItemsNotPurched.Zynh(p));
        purchase.setItem(18, ItemsNotPurched.Zynh(p));
        purchase.setItem(19, ItemsNotPurched.Zynh(p));
        purchase.setItem(20, ItemsNotPurched.Zynh(p));
        purchase.setItem(21, ItemsNotPurched.Zynh(p));
        purchase.setItem(22, ItemsNotPurched.Zynh(p));
        purchase.setItem(23, ItemsNotPurched.Zynh(p));
        purchase.setItem(24, ItemsNotPurched.Zynh(p));
        purchase.setItem(25, ItemsNotPurched.Zynh(p));
        p.openInventory(purchase);
        return purchase;
    }
    public static Inventory TrailsFeature(Player p) {
        Inventory purchase = Bukkit.createInventory(null, 27,Main.color("Available Trails"));
        purchase.setItem(26, ShopItems.GB1(p));
        
        if (p.hasPermission("trails.heart") && PlayersShop.getHeart(p) == 1) {
        	
        	purchase.setItem(11, ShopTrails.HeartClickable(p));
        	
       }else if (p.hasPermission("trails.heart") && PlayersShop.getHeart(p) == 2) {
    	   
    	 purchase.setItem(11, ShopTrails.HeartClickable(p));
    	 
        } else {
        	
        	purchase.setItem(11, ItemsNotPurched.Heart(p));
        	
        }
        
        if (p.hasPermission("trails.smoke") && PlayersShop.getSmoke(p) == 1) {
        	
        	purchase.setItem(13, ShopTrails.SmokeClickable(p));
        	
       }else if (p.hasPermission("trails.smoke") && PlayersShop.getSmoke(p) == 2) {
    	   
    	 purchase.setItem(13, ShopTrails.SmokeClickable(p));
    	 
        } else {
        	
        	purchase.setItem(13, ItemsNotPurched.Smoke(p));
        	
        }
        
        if (p.hasPermission("trails.lavapop") && PlayersShop.getLava(p) == 1) {
        	
        	purchase.setItem(15, ShopTrails.LavaPoPClickable(p));
        	
       }else if (p.hasPermission("trails.lavapop") && PlayersShop.getLava(p) == 2) {
    	   
    	 purchase.setItem(15, ShopTrails.LavaPoPClickable(p));
    	 
        } else {
        	
        	purchase.setItem(15, ItemsNotPurched.LavaPoP(p));
        	
        }
        
        p.openInventory(purchase);
        return purchase;
    }
    public static Inventory haveVillagerDeath(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.VillagerDeathYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveZombieDeath(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.ZombieDeathYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveBatDeath(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.BatDeathYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveWolfDeath(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.WolfDeathYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveCatMeow(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.CatMeowYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveFirework(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.FireworkYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveExplode(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.ExplosionYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static Inventory haveStrike(Player p) {
        Inventory p1 = Bukkit.createInventory(null, 27,Main.color("&5You have an Battle Cry."));
        p1.setItem(0, ShopBattleCry.StrikeYes());
        p1.setItem(26, ShopItems.GB1(p));
        p1.setItem(1, ItemsNotPurched.Zynh(p));
        p1.setItem(10, ItemsNotPurched.Zynh(p));
        p1.setItem(11, ShopBattleCry.RemoveBattleCry(p));
        p1.setItem(19, ItemsNotPurched.Zynh(p));
        p.openInventory(p1);
		return p1;	
    }
    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&',s);
    }
    public static String decolor(String s) {
        return ChatColor.stripColor(color(s));
    }
    public static Main getInstance() {
        return instance;
    } 

    public static String F(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    
    @EventHandler
    public void onDamageWitherSkeleton(EntityDamageEvent e) {
        if (e.getEntity() instanceof WitherSkull || e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDeathRespawn(PlayerDeathEvent e) {
        final Player player = e.getEntity().getPlayer();
        final Player Killer = e.getEntity().getKiller();
        SetSpawnUtil.teleport(player);
            if (Killer.hasPermission("battlecry.villagerdeath") && PlayersShop.getVillagerdeath(Killer) == 2)
            {
                player.playSound(player.getLocation(), Sound.VILLAGER_DEATH, 0.9f, 0.9f); 
                Killer.playSound(Killer.getLocation(), Sound.VILLAGER_DEATH, 0.9f, 0.9f); 

                for (Player all : Bukkit.getOnlinePlayers())
                {
                	TabAPI.UpdateTablist(player);
                	TabAPI.UpdateTablist(Killer);
                	
        			BoardAPI.onScoreboard(player);
        			BoardAPI.onScoreboard(all);
        			BoardAPI.onScoreboard(Killer);
                }
            } else if (Killer.hasPermission("battlecry.zombiedeath") && PlayersShop.getZombiedeath(Killer) == 2)
                {
                player.playSound(player.getLocation(), Sound.ZOMBIE_DEATH, 0.9f, 0.9f); 
                Killer.playSound(Killer.getLocation(), Sound.ZOMBIE_DEATH, 0.9f, 0.9f); 

                for (Player all : Bukkit.getOnlinePlayers())
                {
                	TabAPI.UpdateTablist(player);
                	TabAPI.UpdateTablist(Killer);
                	
        			BoardAPI.onScoreboard(player);
        			BoardAPI.onScoreboard(all);
        			BoardAPI.onScoreboard(Killer);
                }
                
           } else if (Killer.hasPermission("battlecry.batdeath") && PlayersShop.getBatdeath(Killer) == 2)
                {
                player.playSound(player.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f); 
                Killer.playSound(Killer.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f); 

                for (Player all : Bukkit.getOnlinePlayers())
                {
                	TabAPI.UpdateTablist(player);
                	TabAPI.UpdateTablist(Killer);
                	
        			BoardAPI.onScoreboard(player);
        			BoardAPI.onScoreboard(all);
        			BoardAPI.onScoreboard(Killer);
                }
           } else if (Killer.hasPermission("battlecry.wolfdeath") && PlayersShop.getWolfdeath(Killer) == 2)
                {
                player.playSound(player.getLocation(), Sound.WOLF_HOWL, 5.4f, 34.0f);
                Killer.playSound(Killer.getLocation(), Sound.WOLF_HOWL, 5.4f, 34.0f);

                for (Player all : Bukkit.getOnlinePlayers())
                {
                	TabAPI.UpdateTablist(player);
                	TabAPI.UpdateTablist(Killer);
                	
        			BoardAPI.onScoreboard(player);
        			BoardAPI.onScoreboard(all);
        			BoardAPI.onScoreboard(Killer);
                }
           } else if (Killer.hasPermission("battlecry.catmeow") && PlayersShop.getCatMeowdeath(Killer) == 2)
                {
                player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
                Killer.playSound(Killer.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);

                for (Player all : Bukkit.getOnlinePlayers())
                {
                	TabAPI.UpdateTablist(player);
                	TabAPI.UpdateTablist(Killer);
                	
        			BoardAPI.onScoreboard(player);
        			BoardAPI.onScoreboard(all);
        			BoardAPI.onScoreboard(Killer);
                }
          } else if (Killer.hasPermission("battlecry.Fireworks") && PlayersShop.getFirework(Killer) == 2)
                {
              Firework Firework = Killer.getWorld().spawn(Killer.getLocation(), Firework.class);
              FireworkMeta Data = Firework.getFireworkMeta();
              Data.addEffects(new FireworkEffect[] { FireworkEffect.builder().withColor(Color.GREEN).with(FireworkEffect.Type.BURST).build() });
              Data.setPower(2);
              Firework.setFireworkMeta(Data);
        	  Killer.getWorld().playEffect(Killer.getLocation(), Effect.FIREWORKS_SPARK, 2);
        	  Killer.playSound(Killer.getLocation(), Sound.FIREWORK_BLAST, 10.0f, 10.0f);
              player.spigot().respawn();
              for (Player all : Bukkit.getOnlinePlayers())
              {
              	TabAPI.UpdateTablist(player);
              	TabAPI.UpdateTablist(Killer);
              	
      			BoardAPI.onScoreboard(player);
      			BoardAPI.onScoreboard(all);
      			BoardAPI.onScoreboard(Killer);
              }
          } else if (Killer.hasPermission("battlecry.Explode") && PlayersShop.getExplode(Killer) == 2)
                {
              Killer.getWorld().playEffect(Killer.getLocation(), Effect.EXPLOSION_HUGE, 10);
        	  Killer.getWorld().playEffect(Killer.getLocation(), Effect.EXPLOSION, 2);
        	  Killer.playSound(Killer.getLocation(), Sound.EXPLODE, 100.0f, 100.0f);
              player.spigot().respawn();
              for (Player all : Bukkit.getOnlinePlayers())
              {
              	TabAPI.UpdateTablist(player);
              	TabAPI.UpdateTablist(Killer);
              	
      			BoardAPI.onScoreboard(player);
      			BoardAPI.onScoreboard(all);
      			BoardAPI.onScoreboard(Killer);
              }
          } else if (Killer.hasPermission("battlecry.Strike") && PlayersShop.getStrike(Killer) == 2)
                {
             ((CraftPlayer) (Killer)).getHandle().playerConnection.sendPacket(new PacketPlayOutSpawnEntityWeather(new EntityLightning(((CraftPlayer) (Killer)).getHandle().getWorld(), ((Killer)).getLocation().getX(), ((Killer)).getLocation().getY(), ((Killer)).getLocation().getZ(), false, false)));
             ((CraftPlayer) (Killer)).getHandle().playerConnection.sendPacket(new PacketPlayOutNamedSoundEffect("ambient.weather.thunder", ((Killer)).getLocation().getX(), ((Killer)).getLocation().getY(), ((Killer)).getLocation().getZ(), 10000.0F, 63));
        	  Killer.getWorld().strikeLightning(Killer.getLocation().add(0,0,5));
        	  Killer.playSound(Killer.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);
              player.spigot().respawn();
              for (Player all : Bukkit.getOnlinePlayers())
              {
              	TabAPI.UpdateTablist(player);
              	TabAPI.UpdateTablist(Killer);
              	
      			BoardAPI.onScoreboard(player);
      			BoardAPI.onScoreboard(all);
      			BoardAPI.onScoreboard(Killer);
              }
            } else {

        		if (player.getWorld().getName().equalsIgnoreCase("PVP"))
        		{
        			SetSpawnUtil.teleport(player);
                    for (Player all : Bukkit.getOnlinePlayers())
                    {
                    	TabAPI.UpdateTablist(player);
                    	TabAPI.UpdateTablist(Killer);
                    	
            			BoardAPI.onScoreboard(player);
            			BoardAPI.onScoreboard(all);
            			BoardAPI.onScoreboard(Killer);
                    }
        		}
            }
    }
	public static void ServerTP(Player p, String Server) {
        try {
          ByteArrayOutputStream b = new ByteArrayOutputStream();
          DataOutputStream out = new DataOutputStream(b);
          out.writeUTF("Connect");
          out.writeUTF(Server);
          p.getPlayer().sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
        } catch (Exception localException) {
        }
    }
}