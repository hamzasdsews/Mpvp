package me.abdullah.pvp.utils;

import java.lang.reflect.Field;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
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
	        final GameProfile profile = new GameProfile(UUID.fromString("2d6f1f87-ee28-4c8d-bf01-07cdaeb71ab8"), null);
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
	        Head("Head", 0, "Head", 0, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRlNzE2NzFkYjVmNjlkMmM0NmEwZDcyNzY2YjI0OWMxMjM2ZDcyNjc4MmMwMGEwZTIyNjY4ZGY1NzcyZDRiOSJ9fX0=", "Head");
	        
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