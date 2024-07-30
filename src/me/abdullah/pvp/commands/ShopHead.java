package me.abdullah.pvp.commands;

import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import com.mojang.authlib.*;
import com.mojang.authlib.properties.*;
import java.lang.reflect.*;

public class ShopHead
{
    public static Heads HeadAPI;
    
    public static ItemStack getHead(final Heads head) {
        return head.getItemStack();
    }
    
    public static ItemStack getHead(final String name) {
        final ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta meta = (SkullMeta)stack.getItemMeta();
        meta.setOwner(Bukkit.getPlayer(name).getName());
        stack.setItemMeta((ItemMeta)meta);
        return stack;
    }
    
    private static ItemStack createSkull(final String url, final String name) {
        final ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        }
        final SkullMeta headMeta = (SkullMeta)head.getItemMeta();
        final GameProfile profile = new GameProfile(UUID.fromString("85f60aef-4945-4790-8a6e-853dd6a33617"), null);
        profile.getProperties().put("textures", new Property("textures", url));
        try {
            final Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        }
        catch (IllegalArgumentException ex) {}
        catch (NoSuchFieldException ex2) {}
        catch (SecurityException ex3) {}
        catch (IllegalAccessException ex4) {}
        head.setItemMeta((ItemMeta)headMeta);
        return head;
    }
    
    public enum Heads
    {
        Head("Head", 0, "Head", 0, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM3Y2FlNWM1MWViMTU1OGVhODI4ZjU4ZTBkZmY4ZTZiN2IwYjFhMTgzZDczN2VlY2Y3MTQ2NjE3NjEifX19", "Head");
        
        private ItemStack item;
        private String idTag;
        
        private Heads(final String s2, final int n2, final String s, final int n, final String texture, final String id) {
            this.item = createSkull(texture, id);
            this.idTag = id;
        }
        
        public ItemStack getItemStack() {
            return this.item;
        }
        
        public String getName() {
            return this.idTag;
        }
    }
}
