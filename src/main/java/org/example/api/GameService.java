package org.example.api;

import org.example.dto.Response;
import org.example.dto.TurnResponse;
import org.example.dto.WinnerResponse;
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
        }
        return game.getOpponent();
    }

    public Response takeAction(String action){
        if(!game.getHero().isAlive()) {
            throw new IllegalStateException("HERO IS DEAD");
        }

        String heroMove = "";
        String heroName = game.getHero().getUnitName();
        String opponentName = game.getOpponent().getUnitName();

        switch(action){
            case "attack":
                int damage = game.getHero().attack(game.getOpponent());

                if(damage > 0) {
                    heroMove = String.format("%s ATTACKED %s, THEY TOOK %d DAMAGE", heroName, opponentName, damage);
                } else {
                    heroMove = String.format("%s MISSED %s, THEY TOOK %d DAMAGE", heroName, opponentName, damage);
                }
                break;

            case "giveup":
                game.getHero().giveUp();
                heroMove = String.format("%s HAS GIVEN UP", heroName);
                break;

            case "heal":
                int hp = game.getHero().heal();
                heroMove = String.format("%s HEALED THEMSELVES, THEY'RE NOW %d HP!", heroName, hp);
                break;

            default:
                break;
        }

        int damage = game.getOpponent().attack(game.getHero());
        String opponentMove = String.format("%s ATTACKED %s, THEY TOOK %d DAMAGE", opponentName, heroName, damage);

        TurnResponse turnResponse = new TurnResponse(game, opponentMove, heroMove);
        if(!game.getHero().isAlive() || !game.getOpponent().isAlive()){
            WinnerResponse winnerResponse = new WinnerResponse(turnResponse, isWinner());
            game = new Game();
            return winnerResponse;
        }
        return turnResponse;
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
