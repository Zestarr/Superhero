package com.zestarr.main;

import com.zestarr.main.Events.ChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("-------------------------" +  "\n\n" + ChatColor.RED + "Superhero plugin has been enabled!" + "\n\n" + "-------------------------");

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
