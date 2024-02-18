package org.example.engine;



import org.example.units.Hero;
import org.example.units.Unit;

import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static Hero hero;
    private static Unit opponent;
    public static void startGame(){
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("            NEW GAME STARTED");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        createHero();
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
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
            System.out.println("            ROUND " + ++round);
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
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
        do{
            hero.displayActions();
            choice = scanner.nextInt();
        }while(choice < 1 || choice > 3);

        switch (choice){
            case 1:
                hero.attack(opponent);
                break;
            case 2:
                hero.heal();
                break;
            case 3:
                hero.giveUp();
                break;
            default:
                break;
        }
    }
}
