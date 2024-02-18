package org.example.units;

import java.util.Random;

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
        System.out.println("Hero Stats:");
        super.printSeparator();
        System.out.println("Name:\t\t\t" + unitName);
        System.out.println("HP:\t\t\t\t" + currentHp + "/" + maxHp);
        System.out.println("Damage:\t\t\t" + maxDmg);
        System.out.println("Max heal:\t\t" + maxHeal);
        System.out.println("Level:\t\t\t" + currentLevel);
        super.printSeparator();
        System.out.println();
    }
    public void heal(){
        int heal = random.nextInt(maxHeal - 1) + 1;
        currentHp += heal;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        }

    }

    public void displayActions(){
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("CHOOSE ACTION:");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("1. ATTACK");
        System.out.println("2. HEAL");
        System.out.println("3. GIVE UP");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
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
