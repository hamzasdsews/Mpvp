/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_7_R4.ChatSerializer
 *  net.minecraft.server.v1_7_R4.EntityPlayer
 *  net.minecraft.server.v1_7_R4.IChatBaseComponent
 *  net.minecraft.server.v1_7_R4.NetworkManager
 *  net.minecraft.server.v1_7_R4.Packet
 *  net.minecraft.server.v1_7_R4.PacketPlayOutChat
 *  net.minecraft.server.v1_7_R4.PlayerConnection
 *  org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBarAPI {
    public static void sendActionBar(Player P, String Msg) {
        CraftPlayer CraftPlayer2 = (CraftPlayer)P;
        IChatBaseComponent ChatComponent = ChatSerializer.a((String)("{\"text\": \"" + Msg.replaceAll("&", "\u00a7") + "\"}"));
        PacketPlayOutChat Packet2 = new PacketPlayOutChat(ChatComponent, (byte) 2);
        CraftPlayer2.getHandle().playerConnection.sendPacket((Packet)Packet2);
    }
    public static void sendOutError(Entity entity, String Msg) {
        CraftPlayer CraftPlayer2 = (CraftPlayer)entity;
        IChatBaseComponent ChatComponent = ChatSerializer.a((String)("{\"text\": \"" + Msg.replaceAll("&", "\u00a7") + "\"}"));
        PacketPlayOutChat Packet2 = new PacketPlayOutChat(ChatComponent, (byte) 2);
        CraftPlayer2.getHandle().playerConnection.sendPacket((Packet)Packet2);
    }
}

