package org.example.units;

import java.util.Random;

import static org.example.Constants.separator1;
import static org.example.Constants.separator2;

public class Hero extends Unit {
    int maxHeal;
    int currentLevel;
    Random random = new Random();

    public Hero(String name){
        super(name, 25, 10);
        maxHeal = 5;
        currentLevel = 1;
    }

    @Override
    public void displayStats(){
        String stats = """
                \t\t\t\tHero Stats:
                %s
                NAME:\t\t\t%s
                HP:\t\t\t\t%d/%d
                MAX DAMAGE:\t\t%d
                MAX HEAL:\t\t%d
                LEVEL:\t\t\t%d
                %s
                """;
        System.out.printf(stats, separator2, unitName, currentHp, maxHp, maxDmg, maxHeal, currentLevel, separator2);
    }

    public void heal(){
        int heal = random.nextInt(maxHeal - 1) + 1;
        currentHp += heal;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public void displayActions(){
        String actions = """
                %s
                CHOOSE ACTION:
                %s
                1. ATTACK
                2. HEAL
                3. GIVE UP
                %s
                """;
        System.out.printf(actions, separator1, separator1, separator1);
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
