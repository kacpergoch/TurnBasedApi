package org.example.units;

import java.util.Random;

public abstract class Unit {
    Random random = new Random();
    public String unitName;
    int maxHp;
    int currentHp;
    int maxDmg;

    Unit(String unitName, int maxHp, int maxDmg){
        this.unitName = unitName;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxDmg = maxDmg;
    }
    public void displayStats(){
        System.out.println("Unit Stats:");
        printSeparator();
        System.out.println("Name:\t\t\t" + unitName);
        System.out.println("HP:\t\t\t\t" + currentHp + "/" + maxHp);
        System.out.println("Max Damage:\t\t" + maxDmg);
        printSeparator();
        System.out.println();
    }

    public void takeDamage(int damage){
        currentHp -= damage;
    }

    public void attack(Unit opponent){
        int damage = random.nextInt(maxDmg);
        if (damage > 0){
            opponent.takeDamage(damage);
        }
    }

    public boolean isAlive(){
        return currentHp > 0;
    }

    public void printSeparator(){
        System.out.println("==========================================");
    }

}
