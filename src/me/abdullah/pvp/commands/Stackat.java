package me.abdullah.pvp.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.abdullah.pvp.a.main.Main;



public class Stackat implements Listener{

	@EventHandler
	public void onRulesAnd3Qwbat(InventoryClickEvent e) {
	Player p = (Player)e.getWhoClicked();
		try
		{
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("&5➤ Rules")))
			{
				e.setCancelled(true);
			}
			if (e.getInventory().getName().equalsIgnoreCase(Main.color("&5➤ 3QWBAT")))
			{
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&6&lNext &e&lPage.")))
			{
				e.setCancelled(true);
				RulesAnd3qwbat.qwbat(p);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 100.0f, 100.0f);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&6&lPrevious &e&lPage.")))
			{
				e.setCancelled(true);
				RulesAnd3qwbat.Rules(p);
				p.playSound(p.getLocation(), Sound.SLIME_WALK2, 100.0f, 100.0f);
			}
		}
		catch (Exception locException)
		{
		}
	}
	// rules
	public static ItemStack Next(Player p) {
		ItemStack i = new ItemStack(Material.ARROW);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&6&lNext &e&lPage."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack PreviusPage(Player p) {
		ItemStack i = new ItemStack(Material.ARROW);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&6&lPrevious &e&lPage."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num1(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l1. &f&lRepect others"));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num2(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l2. &f&lDon't use any hack"));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num3(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l3. &f&lDon't abuse Glitches & Reports"));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num4(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l4. &f&lDon't Swear and Stay Polite."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num5(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l5. &f&lDon't make the glitches."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num6(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l6. &f&lAsk the owner for any bug."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num7(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l7. &f&lJoin Our discord for buy a rank."));
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Num8(Player p) {
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l8. &f&lDon't Swear the &4&lServer."));
		i.setItemMeta(meta);
		return i;
	}
	// 3qwbat.
	public static ItemStack Hacking(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l1. &f&lHacking"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&eBanned &6➥ &a7 &fDays."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Fly(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l2. &f&lFly"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&eBanned &6➥ &a3 &fDays."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack SwearingStaff(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l3. &f&lSwearing Staff."));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&6Same this words:"));
		lore.add(Main.color(""));
		lore.add(Main.color("&c87bh, 7ywan , shrmo6, mneok,"));
		lore.add(Main.color("&cks omk, yn3l shklk , wtf, 3er fek....,"));
		lore.add(Main.color(""));
		lore.add(Main.color("&6Mute &6➥ &a8 &fHours."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack SwearingOwner(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l4. &f&lSwearing Owner."));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&6Same this words:"));
		lore.add(Main.color(""));
		lore.add(Main.color("&c87bh, 7ywan , shrmo6, mneok,"));
		lore.add(Main.color("&cks omk, yn3l shklk , wtf, 3er fek....,"));
		lore.add(Main.color(""));
		lore.add(Main.color("&6Mute &6➥ &a12 &fHours."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack SwearingServer(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l5. &f&lSwearing Server."));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&6Same this words:"));
		lore.add(Main.color(""));
		lore.add(Main.color("&cServer mneok, ping zbal, ks omkm"));
		lore.add(Main.color("&cal owner mneok, ......."));
		lore.add(Main.color(""));
		lore.add(Main.color("&6Mute &6➥ &a12 &fDays."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Spamming(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l6. &f&lSpamming on the chat."));
		ArrayList lore = new ArrayList<>();
		lore.add(Main.color(""));
		lore.add(Main.color("&aand repeat the questions. or something"));
		lore.add(Main.color("&6Same this words:"));
		lore.add(Main.color(""));
		lore.add(Main.color("&ctttttttttttttttt"));
		lore.add(Main.color(""));
		lore.add(Main.color("&6Mute &6➥ &a10 &fHours."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack AbuseReport(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l7. &f&lAbuse Report."));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&4Banned &6➥ &a8 &fHours."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack AbuseGlitch(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l8. &f&lAbuse Glitches"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&4Banned &6➥ &a4 &fHours."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Caps(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l9. &f&lCaps"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&6Mute &6➥ &a15 &fMinutes."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
	public static ItemStack Adveristing(Player p) {
		ItemStack i = new ItemStack(Material.POTION);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Main.color("&c&l10. &f&lAdveristing"));
		ArrayList lore = new ArrayList<>();
		lore.add("");
		lore.add(Main.color("&4Banned &6➥ &a&l20 &fDay."));
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
}
