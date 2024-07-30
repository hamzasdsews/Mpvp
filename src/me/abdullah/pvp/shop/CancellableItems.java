package me.abdullah.pvp.shop;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.naarmc.mysql.mysql.LobbyStats;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPStats;
import me.abdullah.pvp.utils.ActionBarAPI;
import me.abdullah.pvp.utils.BoardAPI;
import me.abdullah.pvp.utils.KitAPI;
import me.abdullah.pvp.utils.PlayersShop;

public class CancellableItems implements Listener{
	@EventHandler
	public void onCLickableAddable(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		Location pLoc = p.getLocation();
		ItemStack item = e.getCurrentItem();
		if (item.equals(ShopBattleCry.VillagerDeathClickable())) {
			e.setCancelled(true);
        	PlayersShop.setVillagerdeath(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&bChoosen the &eVillager Death &bBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.ZombieDeathClickable())) {
			e.setCancelled(true);
        	PlayersShop.setZombiedeath(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&bChoosen the &bZombie Death &bBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.BatDeathClickable())) {
			e.setCancelled(true);
        	PlayersShop.setBatdeath(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&bChoosen the &fBat Death &bBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.WolfDeathClickable())) {
			e.setCancelled(true);
        	PlayersShop.setWolfdeath(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&bChoosen the &3Wolf Death &bBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.CatMeowClickable())) {
			e.setCancelled(true);
        	PlayersShop.setCatMeowdeath(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&bChoosen the &dCat Meow &bBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.FireworkClickable())) {
			e.setCancelled(true);
        	PlayersShop.setFirework(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&f&lChoosen the &eKillEffect &8- &6Fireworks &f&lBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.ExplosionClickable())) {
			e.setCancelled(true);
        	PlayersShop.setExplode(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&f&lChoosen the &eKillEffect &8- &cExplosion &f&lBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopBattleCry.StrikeClickable())) {
			e.setCancelled(true);
        	PlayersShop.setStrike(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&f&lChoosen the &eKillEffect &8- &bLighning Strike &f&lBattle Cry"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopTrails.HeartClickable(p))) {
			e.setCancelled(true);
        	PlayersShop.setHeart(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&6✸ &bChoosen the &cHeart &bTrail &6✸"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopTrails.SmokeClickable(p))) {
			e.setCancelled(true);
        	PlayersShop.setSmoke(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&6✸ &bChoosen the &cSmoke &bTrail &6✸"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
		if (item.equals(ShopTrails.LavaPoPClickable(p))) {
			e.setCancelled(true);
        	PlayersShop.setLava(p, 2);
			ActionBarAPI.sendActionBar(p, Main.color("&6✸ &bChoosen the &cLavaPoP &bTrail &6✸"));
			p.playSound(pLoc, Sound.FIREWORK_BLAST, 9.0f, 9.00f);
			p.closeInventory();
		}
	}
	
	
	
	
	
	
	//     TODO:                  Perks
	
	
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void onClickTNT(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		Location pLoc = p.getLocation();
		ItemStack item = e.getCurrentItem();
		if (item.equals(ShopItems.TnTPerks(p))) {
            if (LobbyStats.getTokens(p) >= 800) {
            	LobbyStats.removeTokens(p, 800);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched x1 &c&lTNT"));
            	p.getInventory().addItem(new ItemStack (Material.TNT));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f800 §cTokens§8.");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 799) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
        }
	}
        	    @EventHandler
        	    public void onClickWEB(InventoryClickEvent e) {
        			Player p = (Player)e.getWhoClicked();
        			Location pLoc = p.getLocation();
        			ItemStack item = e.getCurrentItem();     
        	if (item.equals(ShopItems.CobwebPerks(p))) {
                if (LobbyStats.getTokens(p) >= 300) {
                	LobbyStats.removeTokens(p, 300);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched x1 &f&lCobweb"));
                	p.getInventory().addItem(new ItemStack (Material.WEB));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f300 §cTokens§8.");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 299) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            }
        }
            	@EventHandler
            	public void onClickMoreArrow(InventoryClickEvent e) {
            		Player p = (Player)e.getWhoClicked();
            		Location pLoc = p.getLocation();
            		ItemStack item = e.getCurrentItem();   
               if (item.equals(ShopItems.Arrow(p))) {
                   if (LobbyStats.getTokens(p) >= 1200) {
                   	LobbyStats.removeTokens(p, 1200);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched x1 &fArrow"));
                	p.getInventory().addItem(new ItemStack(Material.ARROW));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f1200 §cTokens§8.");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 1199) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            }
         }
        	@EventHandler
        	public void onClickApple(InventoryClickEvent e) {
        		Player p = (Player)e.getWhoClicked();
        		Location pLoc = p.getLocation();
        		ItemStack item = e.getCurrentItem();
          if (item.equals(ShopItems.ApplePerks(p))) {
              if (LobbyStats.getTokens(p) >= 900) {
                 	LobbyStats.removeTokens(p, 900);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched x1 &eGoldenApple"));
            	p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f900 §cTokens§8.");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 899) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
        }
        	}
        	
        	
        	
        	
        	
        	
        	//     TODO:                  BattleCry
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	@EventHandler
        	public void onClickBattleCry(InventoryClickEvent e)
        	{
        		Player p = (Player)e.getWhoClicked();
        		Location pLoc = p.getLocation();
        		ItemStack item = e.getCurrentItem();  
        		
             //             -      VILLAGER     -
          if (item.equals(ShopBattleCry.VillagerDeathBattleCry())) {
            if (LobbyStats.getTokens(p) >= 5000) {
            	LobbyStats.removeTokens(p, 5000);
            	PlayersShop.setVillagerdeath(p, 1);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched &e&lVillager Death &aBattle Cry."));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f3000 §cTokens§8.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.villagerdeath");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 4999) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
            
            
          } else if (item.equals(ShopBattleCry.ZombieDeathBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setZombiedeath(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &b&lZombie Death &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.zombiedeath");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
                
                
            } else if (item.equals(ShopBattleCry.BatDeathBattleCry())) {
                    if (LobbyStats.getTokens(p) >= 5000) {
                    	LobbyStats.removeTokens(p, 5000);
                    	PlayersShop.setBatdeath(p, 1);
                    	p.sendMessage(Main.prefix + Main.color("&aYou have purched &f&lBat Death &aBattle Cry."));
                        p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                        ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.batdeath");
                        BoardAPI.onScoreboard(p);
                        p.closeInventory();
                    } else {
                    	if (LobbyStats.getTokens(p) <= 4999) {
                        	p.closeInventory();
                            e.setCancelled(true);	
                    	}
                    	p.closeInventory();
                        p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                        p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                        e.setCancelled(true);
                    }
            } else if (item.equals(ShopBattleCry.WolfDeathBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setWolfdeath(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &3Wolf Death &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.wolfdeath");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            } else if (item.equals(ShopBattleCry.CatMeowBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setCatMeowdeath(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &dCat Meow &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.Catmeow");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            } else if (item.equals(ShopBattleCry.FireworkBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setFirework(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &eKillEffect &8- &6Fireworks &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, Main.color("&8[&c&l-&8] &4&l500 &e&lPoints&7."));
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.Fireworks");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            } else if (item.equals(ShopBattleCry.ExplosionBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setExplode(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &eKillEffect &8- &cExplosion &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.Explode");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            } else if (item.equals(ShopBattleCry.StrikeBattleCry())) {
                if (LobbyStats.getTokens(p) >= 5000) {
                	LobbyStats.removeTokens(p, 5000);
                	PlayersShop.setStrike(p, 1);
                	p.sendMessage(Main.prefix + Main.color("&aYou have purched &eKillEffect &8- &bLightning Strike &aBattle Cry."));
                    p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                    ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f5000 §cTokens§8.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set battlecry.Strike");
                    BoardAPI.onScoreboard(p);
                    p.closeInventory();
                } else {
                	if (LobbyStats.getTokens(p) <= 4999) {
                    	p.closeInventory();
                        e.setCancelled(true);	
                	}
                	p.closeInventory();
                    p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                    p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                    e.setCancelled(true);
                }
            }
          }
        	
        	
        	
        	
        	
        	
        	//     TODO:                  Trails
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	@EventHandler
        	public void onClickHeartTrail(InventoryClickEvent e) {
        		Player p = (Player)e.getWhoClicked();
        		Location pLoc = p.getLocation();
        		ItemStack item = e.getCurrentItem();  
           if (item.equals(ShopTrails.HeartTrail(p))) {
            if (LobbyStats.getTokens(p) >= 3000) {
            	LobbyStats.removeTokens(p, 3000);
                PlayersShop.setHeart(p,1);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched &a&lHearts &bTrail"));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f3000 §cTokens§8.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set trails.heart");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 2999) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
        }
        	}
        	@EventHandler
        	public void onClickSmokeTrail(InventoryClickEvent e) {
        		Player p = (Player)e.getWhoClicked();
        		Location pLoc = p.getLocation();
        		ItemStack item = e.getCurrentItem();
                if (item.equals(ShopTrails.SmokeTrail(p))) {
            if (LobbyStats.getTokens(p) >= 3000) {
            	LobbyStats.removeTokens(p, 3000);
            	PlayersShop.setSmoke(p,1);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched &7&lSmoke &bTrail"));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f3000 §cTokens§8.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set trails.smoke");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 2999) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
        }
        	}
        	@EventHandler
        	public void onClickLavaPoPTrail(InventoryClickEvent e) {
        		Player p = (Player)e.getWhoClicked();
        		Location pLoc = p.getLocation();
        		ItemStack item = e.getCurrentItem();    
          if (item.equals(ShopTrails.LavaPoPTrail(p))) {
            if (LobbyStats.getTokens(p) >= 3000) {
            	LobbyStats.removeTokens(p, 3000);
            	PlayersShop.setLava(p,1);
            	p.sendMessage(Main.prefix + Main.color("&aYou have purched &6&lLavaPoP &bTrail"));
                p.playSound(pLoc, Sound.LEVEL_UP, 5.4f, 34.0f);
                ActionBarAPI.sendActionBar(p, "§8§l▎ §b§lNaar§e§lMC §8┃ §c§l✖ §f3000 §cTokens§8.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set trails.lavapop");
                BoardAPI.onScoreboard(p);
                p.closeInventory();
            } else {
            	if (LobbyStats.getTokens(p) <= 2999) {
                	p.closeInventory();
                    e.setCancelled(true);	
            	}
            	p.closeInventory();
                p.sendMessage("§8§l▎ §b§lNaar§e§lMC §8┃ " + "§cKill some players to earn §aRandom §ctokens.");
                p.playSound(pLoc, Sound.GLASS, 100f, 100f);
                e.setCancelled(true);
            }
        }
      }
}