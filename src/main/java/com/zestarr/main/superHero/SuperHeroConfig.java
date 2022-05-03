package com.zestarr.main.superHero;

import com.zestarr.main.Main;

public class SuperHeroConfig {

    private Main main;

    private String superHero;

    public SuperHeroConfig(Main main, String superHero) {
        this.main = main;
        this.superHero = superHero;
    }


    public String getName() {
        return main.getConfig().getString(this.superHero + ".Name");
    }

    public String getTraits() {
        return main.getConfig().getString(this.superHero + ".Traits");
    }

    public int getHealth() {
        return main.getConfig().getInt(this.superHero + ".Health");
    }

    public float getDamage() {
        return main.getConfig().getInt(this.superHero + ".Damage");
    }

    public float getSpeed() {
        return main.getConfig().getInt(this.superHero + ".Speed");
    }

    public String getWeakness() {
        return main.getConfig().getString(this.superHero + ".Weakness");
    }

}


