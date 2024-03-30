package org.example.model.units;

import java.util.Random;

import static org.example.Constants.separator1;
import static org.example.Constants.separator2;

public class Hero extends Unit {
    protected int maxHeal;
    protected int currentLevel;
    Random random = new Random();

    public Hero(String name){
        super(name, 25, 10);
        maxHeal = 5;
        currentLevel = 1;
    }

    public String heal(){
        int heal = random.nextInt(maxHeal - 1) + 1;
        currentHp += heal;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        }

        return String.format("%s HEALED FOR %d HP", unitName, heal);
    }

    public void levelUp(){
        currentLevel++;
        maxDmg += 2;
        maxHeal += 2;
        maxHp += 2;
        currentHp = maxHp;
    }

    public String giveUp(){
        currentHp = 0;
        return String.format("%s GAVE UP", unitName);
    }
}
