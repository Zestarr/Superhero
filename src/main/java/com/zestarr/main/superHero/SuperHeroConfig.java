package com.zestarr.main.superHero;

import com.zestarr.main.Main;

public class SuperHeroConfig {

    private Main main;

    public SuperHeroConfig(Main main) {
        this.main = main;
    }

    public String getName(String superHero) {
        return main.getConfig().getString(superHero + ".Name");
    }

    public String getTraits(String superHero) {
        return main.getConfig().getString(superHero + ".Traits");
    }

    public int getHealth(String superHero) {
        return main.getConfig().getInt(superHero + ".Health");
    }

    public double getDamage(String superHero) {
        return main.getConfig().getDouble(superHero + ".Damage");
    }

    public double getSpeed(String superHero) {
        return main.getConfig().getDouble(superHero + ".Speed");
    }

    public String getWeakness(String superHero) {
        return main.getConfig().getString(superHero + ".Weakness");
    }

}


