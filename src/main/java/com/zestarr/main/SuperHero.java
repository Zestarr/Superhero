package com.zestarr.main;

public enum SuperHero {

    CIVILIAN("Civilian", "Nothing", 20, 1f, 0.1f, ""),
    HULK("Hulk", "Melee", 50, 7f, 0.05f, ""),
    DRSTRANGE("Dr. Strange", "Magic", 20, 1f, .13f,"" ),
    HAWKEYE("Hawkeye", "Ranged", 20, 2.5f, 0.11f, ""),
    PROFESSORX("Professor X", "IQ/Healing", 35, 1f, 0.1f,""),
    DEADPOOL("DeadPool", "Stealth", 40, 2f, 0.17f, ""),
    FLASH("Flash", "Speed", 25, 5f, 0.5f, ""),
    SUPERGIRL("Supergirl", "Flight", 40, 4f, 0.25f, ""),
    BATMAN("Bat Man", "Genius", 20, 3f, 0.13f, "");

    private String traits;
    private Integer health;
    private Float damage;
    private Float speed;
    private String name;
    private String weakness;

    SuperHero(String name, String traits, Integer health, Float damage, Float speed, String weakness) {
        this.traits = traits;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.name = name;
        this.weakness = weakness;
    }

    public String getTraits() { return traits; }

    public Integer getHealth() { return health; }

    public Float getDamage() { return damage; }

    public Float getSpeed() { return speed; }

    public String getName() { return name; }

    public String getWeakness() { return weakness; }

    }
