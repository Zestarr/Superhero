package com.zestarr.main;

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
}
