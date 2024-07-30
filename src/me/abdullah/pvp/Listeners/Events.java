package me.abdullah.pvp.Listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.naarmc.mysql.api.TabAPI;
import com.naarmc.mysql.mysql.LobbyStats;
import com.naarmc.mysql.others.BuildingFile;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.combat.CombatTimer;
import me.abdullah.pvp.modes.AutoKit;
import me.abdullah.pvp.modes.Settings;
import me.abdullah.pvp.modes.Spectator;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.BoardAPI;
import me.abdullah.pvp.utils.EntityUtils;
import me.abdullah.pvp.utils.PlayersSettings;
import me.abdullah.pvp.utils.PlayersShop;
import me.abdullah.pvp.utils.SetSpawnUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class Events implements Listener{
    public static ArrayList<Player> PVP = new ArrayList();
    static LuckPerms api = LuckPermsProvider.get();
    
    
//	@EventHandler
//	public void onFixTabMove(PlayerMoveEvent e) {
//		Player p = e.getPlayer();
//    	TabAPI.UpdateTablist(p);
//    	FixTabAPI.Fix(p);
//    	for (Player online : Bukkit.getOnlinePlayers()) {
//        	TabAPI.UpdateTablist(p);
//        	FixTabAPI.Fix(p);
//    	}
//	}
	
	@EventHandler
	public void onBreakBlocks(BlockBreakEvent e) {
		
		Block b = e.getBlock();
		
		Player p = e.getPlayer();
		if (b.getType() == Material.WEB) {
			
			p.sendMessage(Main.prefix + Main.color("&aYou have been removed the &b&lWEB&a!"));			
			e.getBlock().setType(Material.AIR);
		} else if (b.getType() == Material.FIRE) {
			p.sendMessage(Main.prefix + Main.color("&aYou have been removed the &b&lFIRE&a!"));
			e.setCancelled(false);
		} else if (BuildingFile.getbuilding(p.getName()) == 0){
			p.sendMessage(Main.prefix + Main.color("&aYou can't break the &c&l" + b.getType() + "&a!"));
			e.setCancelled(true);
		} else if (BuildingFile.getbuilding(p.getName()) == 1) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
		
	}
	  @EventHandler
	  public void Removeblocks(BlockPlaceEvent e) {
	    Block b = e.getBlock();
	    if (b.getLocation().getY() >= 100) {
	    if ((b.getType().equals(Material.TNT)) || (b.getType().equals(Material.WEB)) || (b.getType().equals(Material.FLINT_AND_STEEL)) || (b.getType().equals(Material.FIRE)))
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          b.setType(Material.AIR);
	        }
	      }
	      , 1L);
	  } else {
		    if ((b.getType().equals(Material.TNT)) || (b.getType().equals(Material.WEB)) || (b.getType().equals(Material.FLINT_AND_STEEL)) || (b.getType().equals(Material.FIRE)))
			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
			      {
			        public void run()
			        {
			          b.setType(Material.AIR);
			        }
			      }
			      , 50L);
	  }}
	    @EventHandler
	    public void onDecay(LeavesDecayEvent e) {
	        e.setCancelled(true);
	    }
	    
	    @EventHandler
	    public void onSpread(BlockSpreadEvent e) {
	        e.setCancelled(true);
	    }
	
	@EventHandler
	public void onPlaceRed(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (b.getType() == Material.REDSTONE_COMPARATOR_OFF) {
			p.updateInventory();
            p.setItemInHand(Settings.Item(p));
			e.setCancelled(true);
		}
		if (b.getType() == Material.REDSTONE_COMPARATOR_ON) {
			p.updateInventory();
            p.setItemInHand(Settings.Item(p));
			e.setCancelled(true);
		}
		if (b.getType() == Material.REDSTONE_COMPARATOR) {
			p.updateInventory();
            p.setItemInHand(Settings.Item(p));
			e.setCancelled(true);
		}
	}
    
    @EventHandler
    public void onPVPMove(PlayerMoveEvent e)
    {
    	Player player = e.getPlayer();
		if (player.getLocation().getY() >= 95 && PVP.contains(player) && player.getWorld().getName().equalsIgnoreCase("PVP"))
		{
			player.getWorld().setPVP(false);
		} else {
			player.getWorld().setPVP(true);
		}
    }
    @EventHandler
    public void q(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        p.setLevel(0);
       	for (Player all : Bukkit.getOnlinePlayers())
    	{
            BoardAPI.onScoreboard(all);
            BoardAPI.onScoreboard(p);
    	}
        if (CombatTimer.combat.containsKey(p))
        {
        	for (Player all : Bukkit.getOnlinePlayers())
        	{
        		all.sendMessage(Main.prefix + Main.color(p.getDisplayName() + " &ahas left on combat mode!"));
        	}
        }
    }
	@EventHandler
	public void onRespawnKits(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		PlayerInventory pInv = p.getInventory();
		SetSpawnUtil.teleport(p);	
        AutoKit.Enabled(p);
		for (Player all : Bukkit.getOnlinePlayers())
		{
//        	FixTabAPI.Fix(p);
        	
			BoardAPI.onScoreboard(p);
			BoardAPI.onScoreboard(all);
        }
	}

	@EventHandler
	public void onClickAtCustom(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (e.getClickedBlock().getType() == Material.HOPPER) {
				e.setCancelled(true);
			}
            if(e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
            	e.setCancelled(true);
            }
            if(e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
            	e.setCancelled(true);
            }
            if(e.getClickedBlock().getType() == Material.ANVIL) {
            	e.setCancelled(true);
            }
		}
	}
	 @EventHandler
    public void onPlayerMovingAtPlates(PlayerMoveEvent e) {
		Location loc = e.getPlayer().getLocation();
		World world = e.getPlayer().getWorld();
        Player p = e.getPlayer();
        if (p.getLocation().getBlock().getType() == Material.IRON_PLATE) {
            Vector v = p.getLocation().getDirection().multiply(2).setY(1);
            p.setVelocity(v);
            p.playSound(loc, Sound.BAT_TAKEOFF, 1.0f, 1.0f);
            world.playEffect(loc, Effect.LAVA_POP, 10);
        }
    }
    @EventHandler
    public void onJoinMessages(PlayerJoinEvent e) {    	
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);
		PlayerInventory pInv = p.getInventory();
		LobbyStats.register(p);
		PVP.add(p);		
		SetSpawnUtil.teleport(p);
    	PlayersShop.setHeart(p, 1);
        AutoKit.Enabled(p);
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
        BoardAPI.onScoreboard(p);
		int points = PVPStats.getPoints(p.getName());
		if (points <= 0)
		{
			PVPStats.setPoints(p, 1000);
		}
		if (points <= 100)
		{
			PVPStats.setPoints(p, 1000);
		}
		if (points <= 200)
		{
			PVPStats.setPoints(p, 1000);
		}
		if (points <= -10)
		{
			PVPStats.setPoints(p, 1000);
		}
        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
	            p.setDisplayName(Main.color("&e") + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §e" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("coowner")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
	            p.setDisplayName("§8┃ §bCO §8┃ §e" + p.getName());
				s.playSound(p.getLocation(), Sound.LEVEL_UP, 0.1f, 0.1f);
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §bCO §8┃ §e" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
	            p.setDisplayName("§1" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §1" + p.getName()));
		}
        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				 p.setDisplayName("§4§l" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §4§l" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§4" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §4" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§cSr §8┃ §c" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §cSr §8┃ §c" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§c" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §c" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§3" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §3" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§d" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §d" + p.getName() + " &c❤"));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
				p.setDisplayName("§f" + p.getName());
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §5" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				p.setDisplayName("§6" + p.getName());
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §a" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				p.setDisplayName("§b" + p.getName());
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §b" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				p.setDisplayName("§a" + p.getName());
				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §6" + p.getName()));
		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("default")) {
			p.setDisplayName("§9" + p.getName());
			e.setJoinMessage(null);
		} else {		
			e.setJoinMessage(null);
		}
        if (!PVPStats.playerExists(p.getName()))
        {
            PVPStats.register(p);
        }
		for (Player all : Bukkit.getOnlinePlayers())
		{
			BoardAPI.onScoreboard(p);
			BoardAPI.onScoreboard(all);
			TabAPI.UpdateTablist(all);
			TabAPI.UpdateTablist(p);
		}
	}
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();
        p.setLevel(0);
		for (Player all : Bukkit.getOnlinePlayers())
		{
			TabAPI.UpdateTablist(all);
			TabAPI.UpdateTablist(p);
			BoardAPI.onScoreboard(p);
			BoardAPI.onScoreboard(all);
		}
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        Main.spectate.remove(p.getName());
        if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("owner")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §e" + p.getName()));
     		}
        else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("coowner")) {
			for (Player s : Bukkit.getOnlinePlayers()) {
				s.playSound(p.getLocation(), Sound.LEVEL_UP, 0.1f, 0.1f);
			}
			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §bCO §8┃ §e" + p.getName()));
		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("developer")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §1" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("headadmin")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §4§l" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("admin")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §4" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("srmod")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §cSr §8┃ §c" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mod")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §2" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("builder")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §3" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("friendly")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §a+ §8┃ §d" + p.getName() + " &c❤"));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("youtuber")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
     				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
     			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §5" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("king")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
    				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
    			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §a" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("mvp")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
    				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
    			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §b" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("vip")) {
     			for (Player s : Bukkit.getOnlinePlayers()) {
    				s.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.1f, 0.1f);
    			}
     			Bukkit.broadcastMessage(Main.color("§8┃ §c- §8┃ §6" + p.getName()));
     		}
             else if (api.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("default")) {
     			e.setQuitMessage(null);
     		} else {		
     			e.setQuitMessage(null);
     		}
        }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {
//            event.getBlock().setType(Material.AIR);
            Entity tnt = event.getPlayer().getWorld().spawn(event.getBlock().getLocation(), TNTPrimed.class);
            ((TNTPrimed)tnt).setFuseTicks(40);
        }
    }
    @EventHandler
    public void onDamageByEntityFFF(EntityDamageEvent event) {
     if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            event.setCancelled(true);
        	}
    	if (event.getCause().equals(EntityDamageEvent.DamageCause.WITHER) || event.getCause().equals(EntityDamageEvent.DamageCause.FALL) || event.getCause().equals(EntityDamageEvent.DamageCause.FALLING_BLOCK) || event.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) {
            event.setCancelled(true);
    	} else {
    		event.setCancelled(false);
    	}
    }
    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        e.setCancelled(false);
        if (e.getEntity().getType() == EntityType.MAGMA_CUBE || e.getEntity().getType() == EntityType.HORSE || e.getEntity().getType() == EntityType.CAVE_SPIDER || e.getEntity().getType() == EntityType.PIG || e.getEntity().getType() == EntityType.CREEPER || e.getEntity().getType() == EntityType.ZOMBIE || e.getEntity().getType() == EntityType.WITCH || e.getEntity().getType() == EntityType.SHEEP || e.getEntity().getType() == EntityType.SPIDER || e.getEntity().getType() == EntityType.SILVERFISH || e.getEntity().getType() == EntityType.ENDERMITE || e.getEntity().getType() == EntityType.MUSHROOM_COW || e.getEntity().getType() == EntityType.SQUID || e.getEntity().getType() == EntityType.PIG_ZOMBIE || e.getEntity().getType() == EntityType.ENDERMAN || e.getEntity().getType() == EntityType.GHAST || e.getEntity().getType() == EntityType.SPIDER || e.getEntity().getType() == EntityType.OCELOT || e.getEntity().getType() == EntityType.CHICKEN || e.getEntity().getType() == EntityType.HORSE || e.getEntity().getType() == EntityType.RABBIT || e.getEntity().getType() == EntityType.PIG || e.getEntity().getType() == EntityType.COW || e.getEntity().getType() == EntityType.BAT || e.getEntity().getType() == EntityType.SLIME || e.getEntity().getType() == EntityType.GUARDIAN || e.getEntity().getType() == EntityType.CREEPER || e.getEntity().getType() == EntityType.ZOMBIE || e.getEntity().getType() == EntityType.WITCH || e.getEntity().getType() == EntityType.WOLF) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() == EntityType.PRIMED_TNT) {
            event.blockList().clear();
        }
    }
@EventHandler
public void onPlayer(FoodLevelChangeEvent e) {
    e.setCancelled(true);
}

@EventHandler
public void onPlayer(PlayerDropItemEvent e) {
    e.setCancelled(true);
}
@EventHandler
public void on(WeatherChangeEvent e) {
    e.setCancelled(true);
}
@EventHandler
public void onSign(SignChangeEvent e) {
    e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
    e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
    e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
    e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
}
String time(long time) {
    long seconds = time / 1000L;
    long minutes = seconds / 60L;
    long hours = minutes / 60L;
    long days = hours / 24L;
    if (days >= 1L) {
      return String.format("%d day(s), %d hour(s), %d min, %d sec", new Object[] { Long.valueOf(days), Long.valueOf(hours - days * 24L), Long.valueOf(minutes - hours * 60L), Long.valueOf(seconds - minutes * 60L) });
    }
    if (hours >= 1L) {
      return String.format("%d hour(s), %d min %d sec", new Object[] { Long.valueOf(hours), Long.valueOf(minutes - hours * 60L), Long.valueOf(seconds - minutes * 60L) });
    }
    if (minutes >= 1L) {
      return String.format("%d min, %d sec", new Object[] { Long.valueOf(minutes), Long.valueOf(seconds - minutes * 60L) });
    }
    return String.format("%d sec", new Object[] { Long.valueOf(time / 1000L) });
  }

}
