package org.example.model.units;

import java.util.Random;

public class Hero extends Unit {
    protected int maxHeal;
    protected int currentLevel;
    Random random = new Random();

    public Hero(String name){
        super(name, 25, 10);
        maxHeal = 5;
        currentLevel = 1;
    }

    public int heal(){
        int heal = random.nextInt(maxHeal - 1) + 1;
        currentHp += heal;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        }

        return currentHp;
    }

    public void levelUp(){
        currentLevel++;
        maxDmg += 2;
        maxHeal += 2;
        maxHp += 2;
        currentHp = maxHp;
    }

    public void giveUp(){
        currentHp = 0;
    }
}
