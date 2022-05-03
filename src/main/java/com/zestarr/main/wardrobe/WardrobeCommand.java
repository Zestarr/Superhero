package com.zestarr.main.wardrobe;

import com.zestarr.main.Main;
import com.zestarr.main.superHero.SuperHeroConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

import static com.zestarr.main.Main.format;

public class WardrobeCommand implements CommandExecutor {

    private Main main;


    final SuperHeroConfig configManager;
    public WardrobeCommand(Main main) {
        configManager = new SuperHeroConfig(main);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 54, ChatColor.RED + "" + ChatColor.BOLD + "Wardrobe (1/1)");

            addClassGui(inv, "CIVILIAN", "so borringggg | Get the default stats", 0);
            addClassGui(inv, "HULK", "Gain a massive boost to health and damage, at the cost of half your speed!", 1);
            addClassGui(inv, "DRSTRANGE", "Lose all special perks, but gain access to some of the most powerful magic powers!", 2);
            addClassGui(inv, "HAWKEYE", "Gain a slight boost to damage and speed, while gaining a powerful bow!", 3);
            addClassGui(inv, "PROFESSORX", "Gain nearly double the health, while being able to heal your opponents!", 4);
            addClassGui(inv, "DEADPOOL", "Gain boots to all perks, but you can be one shot by any healer! (Professor X)", 5);
            addClassGui(inv, "FLASH", "Run at the speed of light, with the fastest armor set!", 6);
            addClassGui(inv, "SUPERGIRL", "Gain a slight boost to all stats, and the ability to fly!", 7);
            addClassGui(inv, "BATMAN", "Gain slight boosts to all stats, but access to tech worth billions!", 8);

            //------------------------------------------------------------------------

            ItemStack notSelectedDisplay = new ItemStack(Material.RED_CONCRETE);
            for (int i : new int[]{36, 37, 38, 39, 40, 41, 42, 43, 44, 45}) {
                inv.setItem(i, notSelectedDisplay);
            }

            ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            for (int i : new int[]{45, 47, 48, 49, 50, 51, 53}) {
                inv.setItem(i, frame);
            }

            ItemStack arrowPrevious = new ItemStack(Material.ARROW);
            inv.setItem(46, arrowPrevious);

            ItemStack arrowNext = new ItemStack(Material.ARROW);
            inv.setItem(52, arrowNext);

            ItemStack exit = new ItemStack(Material.BARRIER);
            inv.setItem(49, exit);

            player.openInventory(inv);

            return false;
        }
        return false;
    }
    private void addClassGui(Inventory inv, String name, String bio, Integer classCount) {

        ArrayList<ItemStack> armorList = new ArrayList<>();
        armorList.add(new ItemStack(Material.CHAINMAIL_HELMET));
        armorList.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        armorList.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        armorList.add(new ItemStack(Material.CHAINMAIL_BOOTS));

        for (int i = 0; i < armorList.size(); i++) {
            ItemMeta Meta = armorList.get(i).getItemMeta();
            Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + configManager.getName(name));
            Meta.setLore(Arrays.asList(ChatColor.GRAY + bio, format(
                    "&6 Traits: &c" + configManager.getTraits(name)
                            + "&6 Health: &c" + configManager.getHealth(name)
                            + "&6 Damage: &c" + configManager.getDamage(name)
                            + "&6 Speed: &c" + configManager.getSpeed(name)
            )));

            armorList.get(i).setItemMeta(Meta);
            inv.setItem(9 * i + classCount, armorList.get(i));
        }
    }
}
