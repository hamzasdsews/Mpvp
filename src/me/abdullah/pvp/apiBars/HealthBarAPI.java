package me.abdullah.pvp.apiBars;

import org.bukkit.entity.Player;

public class HealthBarAPI
{
  public static String getHealthLeft(Player p)
  {
    if (p.getHealth() >= 20.0D) {
      return "§e§l☣ §a100% §c❤";
    }

    if ((p.getHealth() >= 19.0D) && (p.getHealth() <= 19.899999999999999D)) {
      return "§e§l☣ §a95% §c❤";
    }

    if ((p.getHealth() >= 18.0D) && (p.getHealth() <= 18.899999999999999D)) {
      return "§e§l☣ §a90% §c❤";
    }

    if ((p.getHealth() >= 17.0D) && (p.getHealth() <= 17.899999999999999D)) {
      return "§e§l☣ §a85% §c❤";
    }

    if ((p.getHealth() >= 16.0D) && (p.getHealth() <= 16.899999999999999D)) {
      return "§e§l☣ §a80% §c❤";
    }

    if ((p.getHealth() >= 15.0D) && (p.getHealth() <= 15.9D)) {
      return "§e§l☣ §a75% §c❤";
    }

    if ((p.getHealth() >= 14.0D) && (p.getHealth() <= 14.9D)) {
      return "§e§l☣ §a70% §c❤";
    }

    if ((p.getHealth() >= 13.0D) && (p.getHealth() <= 13.9D)) {
      return "§e§l☣ §a65% §c❤";
    }

    if ((p.getHealth() >= 12.0D) && (p.getHealth() <= 12.9D)) {
      return "§e§l☣ §a60% §c❤";
    }

    if ((p.getHealth() >= 11.0D) && (p.getHealth() <= 11.9D)) {
      return "§e§l☣ §a55% §c❤";
    }

    if ((p.getHealth() >= 10.0D) && (p.getHealth() <= 10.9D)) {
      return "§e§l☣ §a50% §c❤";
    }

    if ((p.getHealth() >= 9.0D) && (p.getHealth() <= 9.9D)) {
      return "§e§l☣ §a45% §c❤";
    }

    if ((p.getHealth() >= 8.0D) && (p.getHealth() <= 8.9D)) {
      return "§e§l☣ §a40% §c❤";
    }

    if ((p.getHealth() >= 7.0D) && (p.getHealth() <= 7.9D)) {
      return "§e§l☣ §a35% §c❤";
    }

    if ((p.getHealth() >= 6.0D) && (p.getHealth() <= 6.9D)) {
      return "§e§l☣ §a30% §c❤";
    }

    if ((p.getHealth() >= 5.0D) && (p.getHealth() <= 5.9D)) {
      return "§e§l☣ §a25% §c❤";
    }

    if ((p.getHealth() >= 4.0D) && (p.getHealth() <= 4.9D)) {
      return "§e§l☣ §a20% §c❤";
    }

    if ((p.getHealth() >= 3.0D) && (p.getHealth() <= 3.9D)) {
      return "§e§l☣ §a15% §c❤";
    }

    if ((p.getHealth() >= 2.0D) && (p.getHealth() <= 2.9D)) {
      return "§e§l☣ §a10% §c❤";
    }

    if (p.getHealth() >= 1.0D) {
      return "§e§l☣ §a5% §c❤";
    }

    if ((p.getHealth() >= 0.0D) && (p.getHealth() <= 0.9D)) {
      return "§e§l☣ §a0% §c❤";
    }

    return null;
  }
}