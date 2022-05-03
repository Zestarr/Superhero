package com.zestarr.main.events;

import com.zestarr.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ArrowShootEvent implements Listener {

    @EventHandler
    public void onShoot(ProjectileLaunchEvent e) {

        if (e.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();


            Bukkit.getScheduler().runTaskTimer(JavaPlugin.getPlugin(Main.class), () -> {
                Location location = arrow.getLocation();
                for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                    double radius = Math.sin(i) * 1;
                    double height = Math.cos(i) * 1;
                    for (double a = 0; a < Math.PI * 2; a += Math.PI / 10) {
                        double x = Math.cos(a) * radius;
                        double z = Math.sin(a) * radius;

                        location.add(x, height, z);
                        location.getWorld().spawnParticle(Particle.DOLPHIN, location, 1);
                        location.subtract(x, height, z);
                    }
                }
            }, 0, 1);

        }

    }

}
