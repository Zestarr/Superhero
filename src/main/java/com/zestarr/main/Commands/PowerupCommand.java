package com.zestarr.main.Commands;

import com.zestarr.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PowerupCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack powerup = new ItemStack(Material.NETHER_STAR);
            ItemMeta powerupMeta = powerup.getItemMeta();
            powerupMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lPowerUP Tool! &7(Right Click)"));
            powerup.setItemMeta(powerupMeta);

            player.getInventory().setItem(JavaPlugin.getPlugin(Main.class).getConfig().getInt("PowerupSlot"), powerup);

        }

        return false;
    }
}
