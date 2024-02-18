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
        String sfName = String.format("NAME:\t\t\t%s", unitName);
        String sfHp = String.format("HP:\t\t\t\t%d" + "/" + "%d", currentHp, maxHp);
        String sfDmg = String.format("MAX DAMAGE:\t\t%d", maxDmg);
        String sfHeal = String.format("MAX HEAL:\t\t%d", maxHeal);
        String sfLevel = String.format("MAX HEAL:\t\t%d", currentLevel);
        System.out.println(
                "Hero Stats:" + "\n" +
                separator2 + "\n" +
                sfName + "\n" +
                sfHp + "\n" +
                sfDmg + "\n" +
                sfHeal + "\n" +
                sfLevel + "\n" +
                separator2
                );
    }

    public void heal(){
        int heal = random.nextInt(maxHeal - 1) + 1;
        currentHp += heal;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public void displayActions(){
        System.out.println(separator1);
        System.out.println("CHOOSE ACTION:");
        System.out.println(separator1);
        System.out.println("""
                1. ATTACK
                2. HEAL
                3. GIVE UP""");
        System.out.println(separator1);
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
