package com.zestarr.main.wardrobe;

import com.zestarr.main.Main;
import com.zestarr.main.superHero.SuperHeroConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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

    private Main main;

    final SuperHeroConfig configManager;
    public WardrobeListener(Main main) {
        configManager = new SuperHeroConfig(main);
    }
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

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("CIVLIAN"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("CIVLIAN"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("CIVLIAN"));

                        player.setDisplayName(format("&cCivilian &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Civilian &bclass"));

                        break;
                    case 37: // Hulk

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("HULK"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("HULK"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("HULK"));

                        player.setDisplayName(format("&cHulk &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Hulk &bclass"));
                        giveArmor(player, "HULK");

                        break;
                    case 38: // Dr. Strange

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("DRSTRANGE"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("DRSTRANGE"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("DRSTRANGE"));

                        player.setDisplayName(format("&cDr. Strange &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Dr. Strange &bclass"));

                        break;
                    case 39: // Hawk Eye

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("HAWKEYE"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("HAWKEYE"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("HAWKEYE"));

                        player.setDisplayName(format("&cHawk Eye &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Hawk Eye &bclass"));

                        break;
                    case 40: // Professor X

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("PROFESSORX"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("PROFESSORX"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("PROFESSORX"));

                        player.setDisplayName(format("&cProfessor X &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Professor X &bclass"));

                        break;
                    case 41: // Deadpool

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("DEADPOOL"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("DEADPOOL"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("DEADPOOL"));

                        player.setDisplayName(format("&cDeadpool &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Deadpool &bclass"));

                        break;
                    case 42: // Flash

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("FLASH"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("FLASH"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("FLASH"));

                        player.setDisplayName(format("&cFlash &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Flash &bclass"));

                        break;
                    case 43: // Super girl

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("SUPERGIRL"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("SUPERGIRL"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("SUPERGIRL"));
                        player.setAllowFlight(true);

                        player.setDisplayName(format("&cSuper Girl &7" + player.getName()));
                        player.sendMessage(format("&bYou have picked the &3Super Girl &bclass"));

                        break;
                    case 44: // Batman

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth("BATMAN"));
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed("BATMAN"));
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage("BATMAN"));

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

