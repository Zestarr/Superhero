package com.zestarr.main.Wardrobe;

import com.zestarr.main.SuperHero;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.zestarr.main.Main.format;

public class WardrobeListener implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        List<Integer> allowedSelectedSlot = new ArrayList<Integer>();
        allowedSelectedSlot.addAll(Arrays.asList(36, 37, 38, 39, 40, 41, 42, 43, 44));
        if (e.getView().getTitle().equals(ChatColor.RED + "" + ChatColor.BOLD + "Wardrobe (1/1)") && e.getCurrentItem() != null) {
            e.setCancelled(true);
            if (allowedSelectedSlot.contains(e.getRawSlot())) {
                player.setAllowFlight(false);

                for (int i : new int[]{36, 37, 38, 39, 40, 41, 42, 43, 44}) {
                    e.getView().setItem(i, new ItemStack(Material.RED_CONCRETE));
                }
                switch (e.getRawSlot()) {
                    case 36: // Civilian
                        SuperHero CIVILIAN = SuperHero.CIVILIAN;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(CIVILIAN.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(CIVILIAN.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(CIVILIAN.getDamage());

                        player.setDisplayName(format("&cCivilian &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Civilian &bclass"));

                        break;
                    case 37: // Hulk
                        SuperHero HULK = SuperHero.HULK;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(HULK.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(HULK.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(HULK.getDamage());

                        player.setDisplayName(format("&cHulk &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Hulk &bclass"));
                        giveArmor(player, "HULK");

                        break;
                    case 38: // Dr. Strange
                        SuperHero DRSTRANGE = SuperHero.DRSTRANGE;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(DRSTRANGE.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(DRSTRANGE.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(DRSTRANGE.getDamage());

                        player.setDisplayName(format("&cDr. Strange &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Dr. Strange &bclass"));

                        break;
                    case 39: // Hawk Eye
                        SuperHero HAWKEYE = SuperHero.HAWKEYE;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(HAWKEYE.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(HAWKEYE.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(HAWKEYE.getDamage());

                        player.setDisplayName(format("&cHawk Eye &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Hawk Eye &bclass"));

                        break;
                    case 40: // Professor X
                        SuperHero PROFESSORX = SuperHero.PROFESSORX;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(PROFESSORX.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(PROFESSORX.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(PROFESSORX.getDamage());

                        player.setDisplayName(format("&cProfessor X &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Professor X &bclass"));

                        break;
                    case 41: // Deadpool
                        SuperHero DEADPOOL = SuperHero.DEADPOOL;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(DEADPOOL.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(DEADPOOL.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(DEADPOOL.getDamage());

                        player.setDisplayName(format("&cDeadpool &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Deadpool &bclass"));

                        break;
                    case 42: // Flash
                        SuperHero FLASH = SuperHero.FLASH;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(FLASH.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(FLASH.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(FLASH.getDamage());

                        player.setDisplayName(format("&cFlash &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Flash &bclass"));

                        break;
                    case 43: // Super girl
                        SuperHero SUPERGIRL = SuperHero.SUPERGIRL;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(SUPERGIRL.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(SUPERGIRL.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(SUPERGIRL.getDamage());
                        player.setAllowFlight(true);

                        player.setDisplayName(format("&cSuper Girl &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Super Girl &bclass"));

                        break;
                    case 44: // Batman
                        SuperHero BATMAN = SuperHero.BATMAN;

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(BATMAN.getHealth());
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(BATMAN.getSpeed());
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(BATMAN.getDamage());

                        player.setDisplayName(format("&cBatman &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Batman &bclass"));

                        break;
                }
                e.getView().setItem(e.getRawSlot(), new ItemStack(Material.GREEN_CONCRETE));

            }

        }

    }

    public void giveArmor(Player player, String name) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();

        switch (name) {
            case "CIVLIAN":
                System.out.println("dont use that");
                break;
            case "HULK":
                helmetMeta.setDisplayName("Hulk Helmet");
                helmet.setItemMeta(helmetMeta);
                player.getInventory().setHelmet(helmet);


                break;
            case "DRSTRANGE":

                break;
            case "HAWKEYE":

                break;
            case "PROFESSORX":

                break;
            case "DEADPOOL":

                break;
            case "FLASH":

                break;
            case "SUPERGIRL":

                break;
            case "BATMAN":

                break;


        }

    }
}

