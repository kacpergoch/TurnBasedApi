package org.example.engine;

import org.example.units.Dragon;
import org.example.units.Goblin;
import org.example.units.Imp;
import org.example.units.Unit;

import java.util.Random;

public class OpponentSpawner {
    private static Random random = new Random();
    public static Unit spawn(){
        int prob = random.nextInt(100);

        if (prob <= 60) {
            return new Imp();
        } else if (prob <= 90) {
            return new Goblin();
        } else {
            return new Dragon();
        }
    }
}
