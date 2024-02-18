package org.example.units;

import java.util.Random;

import static org.example.Constants.separator2;

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
        String sfName = String.format("NAME:\t\t\t%s", unitName);
        String sfHp = String.format("HP:\t\t\t\t%d" + "/" + "%d", currentHp, maxHp);
        String sfDmg = String.format("MAX DAMAGE:\t\t%d", maxDmg);
        System.out.println("Unit Stats:" + "\n" + separator2 + "\n" + sfName + "\n" + sfHp + "\n" + sfDmg + "\n" + separator2);
    }

    public void takeDamage(int damage){
        currentHp -= damage;
    }

    public void attack(Unit opponent){
        int damage = random.nextInt(maxDmg);
        if (damage > 0){
            opponent.takeDamage(damage);
            System.out.println(separator2 + "\n" + unitName + " ATTACKS " + opponent.unitName + " FOR " + damage + " DMG" + "\n" + separator2);
            return;
        }
        System.out.println(separator2 + "\n" + unitName + " MISSES " + opponent.unitName + "\n" + separator2);
    }

    public boolean isAlive(){
        return currentHp > 0;
    }
}
