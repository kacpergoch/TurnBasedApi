package org.example.model.engine;

import org.example.model.units.Hero;
import org.example.model.units.Unit;

public class Game {
    private Hero hero;
    private Unit opponent;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Unit getOpponent() {
        return opponent;
    }

    public void setOpponent(Unit opponent) {
        this.opponent = opponent;
    }

}
