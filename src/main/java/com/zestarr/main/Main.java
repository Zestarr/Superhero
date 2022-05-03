package com.zestarr.main;

import com.zestarr.main.Commands.FireballCommand;
import com.zestarr.main.Commands.PowerupCommand;
import com.zestarr.main.events.ArrowShootEvent;
import com.zestarr.main.wardrobe.WardrobeCommand;
import com.zestarr.main.events.ChatEvent;
import com.zestarr.main.events.RightClickEvent;
import com.zestarr.main.wardrobe.WardrobeListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main mainInstance;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("-------------------------" +  "\n\n" + "Superhero plugin has been enabled!" + "\n\n" + "-------------------------");

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new RightClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WardrobeListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ArrowShootEvent(), this);

        getCommand("wardrobe").setExecutor(new WardrobeCommand(this));
        getCommand("fireball").setExecutor(new FireballCommand());
        getCommand("powerup").setExecutor(new PowerupCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getMainInstance() { return mainInstance; }
    public static String format(String s) { return ChatColor.translateAlternateColorCodes('&', s); }

}
