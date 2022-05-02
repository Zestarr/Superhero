package com.zestarr.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("-------------------------" +  "\n\n" + "Superhero plugin has been enabled!" + "\n\n" + "-------------------------");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
