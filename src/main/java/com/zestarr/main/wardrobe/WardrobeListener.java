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

                        setAttribute(player, "CIVILIAN");

                        break;
                    case 37: // Hulk

                        setAttribute(player, "HULK");

                        break;
                    case 38: // Dr. Strange

                        setAttribute(player, "DRSTRANGE");

                        break;
                    case 39: // Hawk Eye

                        setAttribute(player, "HAWKEYE");

                        break;
                    case 40: // Professor X

                        setAttribute(player, "PROFESSORX");

                        break;
                    case 41: // Deadpool

                        setAttribute(player, "DEADPOOL");

                        break;
                    case 42: // Flash

                        setAttribute(player, "FLASH");

                        break;
                    case 43: // Super girl

                        setAttribute(player, "SUPERGIRL");

                        break;
                    case 44: // Batman

                        setAttribute(player, "BATMAN");

                        break;
                }
                e.getView().setItem(e.getRawSlot(), new ItemStack(Material.GREEN_CONCRETE));

            }

        }

    }

    public void setAttribute(Player player, String superHero) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(configManager.getHealth(superHero));
        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(configManager.getSpeed(superHero));
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(configManager.getDamage(superHero));

        player.setDisplayName(format("&c" + superHero + "&7 " + player.getName()));
        player.sendMessage(format("&bYou have picked the &3" + superHero + " &bclass"));
    }

    public void giveArmor(Player player, String name) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();

        switch (name) {
            case "CIVLIAN":
                System.out.println(ChatColor.RED + "Why did you pick this?");
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

