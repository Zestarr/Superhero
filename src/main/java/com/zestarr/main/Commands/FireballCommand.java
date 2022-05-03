package com.zestarr.main.Commands;

import com.zestarr.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FireballCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 3) {

                Location location = player.getLocation();

                Bukkit.getScheduler().runTaskTimer(JavaPlugin.getPlugin(Main.class), () -> {
                    for (double i = 0; i <= Math.PI; i += Math.PI / Double.parseDouble(args[2])) {
                        double radius = Math.sin(i) * Double.parseDouble(args[0]);
                        double height = Math.cos(i) * Double.parseDouble(args[1]);
                        for (double a = 0; a < Math.PI * 2; a += Math.PI / Double.parseDouble(args[2])) {
                            double x = Math.cos(a) * radius;
                            double z = Math.sin(a) * radius;

                            location.add(x, height, z);
                            location.getWorld().spawnParticle(Particle.SMALL_FLAME, location, 1);
                            location.subtract(x, height, z);
                        }
                    }
                }, 100, 1);




            } else {
                player.sendMessage("/fireball <radius> <height> <particle frequency> (EX: /fireball 2 2 10)");
            }


        }

        return false;
    }
}



/*





 */