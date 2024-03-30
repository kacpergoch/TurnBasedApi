package org.example.model.units;

import java.util.Random;

import static org.example.Constants.separator2;

public abstract class Unit {
    Random random = new Random();

    public String getUnitName() {
        return unitName;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    protected String unitName;
    protected int maxHp;
    protected int currentHp;
    protected int maxDmg;

    Unit(String unitName, int maxHp, int maxDmg){
        this.unitName = unitName;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxDmg = maxDmg;
    }

    public void takeDamage(int damage){
        currentHp -= damage;
    }

    public String attack(Unit opponent){
        int damage = random.nextInt(maxDmg);
        if (damage > 0){
            opponent.takeDamage(damage);
            return String.format("%s ATTACKS %s FOR %d DMG", unitName, opponent.unitName, damage);
        }
        return String.format("%s MISSES %s",unitName, opponent.unitName);
    }

    public boolean isAlive(){
        return currentHp > 0;
    }
}
