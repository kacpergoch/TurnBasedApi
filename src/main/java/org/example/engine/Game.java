package org.example.engine;



import org.example.units.Hero;
import org.example.units.Unit;
import java.util.Scanner;

import static org.example.Constants.separator1;
import static org.example.Constants.separator2;


public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static Hero hero;
    private static Unit opponent;
    public static void startGame(){
        System.out.println(separator1);
        System.out.println("            NEW GAME STARTED");
        System.out.println(separator1);
        createHero();
        System.out.println(separator1);
        gameLoop();
    }

    private static void gameLoop(){
        while (hero.isAlive()) {
            opponent = OpponentSpawner.spawn();

            duel();
            Unit winner = isWinner();
            System.out.println(winner.unitName + " WON");
            if (winner == hero) {
                hero.levelUp();
                System.out.println("NEW FIGHT");
            } else {
                System.out.println("GAME OVER");
            }
        }
    }

    private static void createHero(){
        String name;
        System.out.println("            NAME YOUR HERO:");
        name = scanner.nextLine();
        hero = new Hero(name);
    }

    private static Unit isWinner(){
        if (hero.isAlive()){
            return hero;
        } else {
            return opponent;
        }
    }

    private static void duel(){
        int round = 0;
        while(hero.isAlive() && opponent.isAlive()){
            ++round;
            System.out.println("            ROUND " + round);
            System.out.println(separator2);
            hero.displayStats();
            opponent.displayStats();
            handleChoice(opponent);
            if (opponent.isAlive()) {
                opponent.attack(hero);
            }
        }
    }

    private static void handleChoice(Unit opponent){
        int choice;
        hero.displayActions();
        while (true) {
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> hero.attack(opponent);
                    case 2 -> hero.heal();
                    case 3 -> hero.giveUp();
                    default -> throw new IllegalArgumentException();
                }

                break;
            } catch (IllegalArgumentException e){
                System.out.println("WRONG VALUE");
            }
        }
    }
}
