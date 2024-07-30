package me.abdullah.pvp.api;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TextAPI {
    public void sendText(Player player, String command, String hovertext, String text) {
        TextComponent component = new TextComponent();
        component.setText(text);
        component.setBold(Boolean.valueOf(true));
        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovertext).create()));
        player.spigot().sendMessage(component);
      }
}
