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
        String stats = """
                \t\t\t\tUnit Stats:
                %s
                NAME:\t\t\t%s
                HP:\t\t\t\t%d/%d
                MAX DAMAGE:\t\t%d
                %s
                """;
        System.out.printf(stats, separator2, unitName, currentHp, maxHp, maxDmg, separator2);
    }

    public void takeDamage(int damage){
        currentHp -= damage;
    }

    public void attack(Unit opponent){
        int damage = random.nextInt(maxDmg);
        if (damage > 0){
            opponent.takeDamage(damage);
            String attack = """
                    %s
                    %s ATTACKS %s FOR %d DMG
                    %s
                    """;
            System.out.printf(attack, separator2, unitName, opponent.unitName, damage, separator2);
            return;
        }
        String miss = """
                %s
                %s MISSES %s
                %s
                """;
        System.out.printf(miss, separator2, unitName, opponent.unitName, separator2);
    }

    public boolean isAlive(){
        return currentHp > 0;
    }
}
