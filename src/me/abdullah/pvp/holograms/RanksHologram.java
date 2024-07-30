package me.abdullah.pvp.holograms;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import me.abdullah.pvp.a.main.Main;

public class RanksHologram {

	
	
	private List<ArmorStand> armorstand = new ArrayList<>();
	private Location location;
	private void createHologram(Player p)
	{
		Location loc = location.clone();
		armorstand.add(createArmorStand("§3§l> §e§lRANKS ON PVP §3§l<", loc.add(0, 0.12, 0)));
		armorstand.add(createArmorStand("§3§l> §6§lOrdered by Kills §3§l<", loc.add(0, -0.24, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §7Bronze §3§l+§e§l0", loc.add(0, -0.26, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §aWarrior §3§l+§e§l100", loc.add(0, -0.28, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §3Power §3§l+§e§l300", loc.add(0, -0.30, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §eSuper §3§l+§e§l700", loc.add(0, -0.32, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §5Crystal §3§l+§e§l900", loc.add(0, -0.34, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §b§lChampion §3§l+§e§l1200", loc.add(0, -0.36, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §c§lMaster §3§l+§e§l2400", loc.add(0, -0.38, 0)));
		armorstand.add(createArmorStand("§3➥ §7FROM: §e§lNa§6§la§e§lry §3§l+§e§l4800", loc.add(0, -0.40, 0)));
	}
	public RanksHologram(Location location, Player p) {
		this.location = location;
		createHologram(p);
	}
	private ArmorStand createArmorStand(String name, Location location) {
		ArmorStand armorStand = (ArmorStand)location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorStand.setGravity(false);
		armorStand.setVisible(false);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		armorStand.setMetadata("TopPVP", new FixedMetadataValue(Main.getInstance(), ""));
		return armorStand;
	}
   }