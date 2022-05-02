package com.zestarr.main.Events;

import com.zestarr.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (JavaPlugin.getPlugin(Main.class).getConfig().getBoolean("CustomChat")) {
            try {
                e.setFormat(ChatColor.translateAlternateColorCodes('&', JavaPlugin.getPlugin(Main.class).getConfig().getString("ChatFormat")));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }


}
