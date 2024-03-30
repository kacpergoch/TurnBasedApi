package org.example.api;

import org.example.dto.TurnResponse;
import org.example.model.engine.Game;
import org.example.model.units.*;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    Game game = new Game();
    Random random = new Random();

    public Game startGame(String playerName){
        createHero(playerName);
        game.setOpponent(spawn());
        return game;
    }

    private void createHero(String playerName){
        game.setHero(new Hero(playerName));
    }

    private Unit isWinner(){
        if (game.getHero().isAlive()){
            return game.getHero();
        } else {
            return game.getOpponent();
        }
    }

    public TurnResponse takeAction(String action){
        if (game.getHero().isAlive()) {

        } else {
            return
        }
    }

    private Unit spawn(){
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
