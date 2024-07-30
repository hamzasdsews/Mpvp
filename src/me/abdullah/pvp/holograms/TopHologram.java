package me.abdullah.pvp.holograms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import me.abdullah.pvp.a.main.Main;
import me.abdullah.pvp.mysql.PVPSQL;

public class TopHologram {


	private List<ArmorStand> armorstands = new ArrayList<>();

	private Location location;

	private static final String HEADER = "§3§l> §a§lTOP ON PVP §3§l<";
	private static final String FOOTER = "§3§l> §aOrdered by Kills §3§l<";
	private static final String DOWNER = "§8";

	private void createhologram(Player p) {
		Bukkit.getWorlds().forEach(worlds -> worlds.getEntities().forEach(entities -> {
			if (entities instanceof ArmorStand && entities.hasMetadata("TopPVP")) {
				entities.remove();
			}
		}));
		try {
			PreparedStatement ps = PVPSQL.getConnection().prepareStatement("SELECT `Playername`,`Kills` FROM PVP ORDER BY Kills DESC LIMIT 10");
			ResultSet result = ps.executeQuery();
			int i = 1;
			while (result.next()) {
				armorstands.add(createArmorStand("§3➥ #" + i + ". §e" + result.getString("Playername") + " §fis have §7[§a" + result.getLong("Kills") + "§7]" + " §fKills.", location.add(0, -0.3, 0)));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public TopHologram(Location location, Player p) {
		this.location = location;
		createhologram(p);
		armorstands.add(createArmorStand(HEADER, location.add(0, 3.5, 0)));
		armorstands.add(createArmorStand(DOWNER, location.add(0, 2, 0)));
		armorstands.add(createArmorStand(FOOTER, location.add(0, -2.5, 0)));
	}

	private ArmorStand createArmorStand(String name, Location location) {
		ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorStand.setGravity(false);
		armorStand.setVisible(false);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		armorStand.setMetadata("TopPVP", new FixedMetadataValue(Main.getInstance(), ""));
		return armorStand;
	}
}