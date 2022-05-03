package com.zestarr.main.Events;

import com.zestarr.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RightClickEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&c&lPowerUP Tool! &7(Right Click)"))) {
            int cooldown = player.getCooldown(player.getInventory().getItemInMainHand().getType());

            if (cooldown == 0) {
                circleCreation(player, 2.0, 0.5, 5.0, 5, Particle.CLOUD);
                player.setVelocity(player.getLocation().getDirection().multiply(3));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aHULK JUMP!"));
                player.setCooldown(player.getInventory().getItemInMainHand().getType(), 100);
            } else {
                e.setCancelled(true);
                player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&3Please wait"), ChatColor.translateAlternateColorCodes('&', "&b" + cooldown / 20  + "&3 Seconds"), 10, 10, 10);
            }


        }



    }

    public void circleCreation(Player player, Double radiusStart, Double heightStart, Double circleCount, Integer particleCount, Particle particle) {

        Location location = player.getLocation();

            for (double i = 0; i <= Math.PI; i += Math.PI / circleCount) {
                double radius = Math.sin(i) * radiusStart;
                double height = Math.cos(i) * heightStart;
                for (double a = 0; a < Math.PI * 2; a += Math.PI / circleCount) {
                    double x = Math.cos(a) * radius;
                    double z = Math.sin(a) * radius;

                    location.add(x, height, z);
                    location.getWorld().spawnParticle(particle, location, particleCount);
                    location.subtract(x, height, z);
                }
            }
    }
}
