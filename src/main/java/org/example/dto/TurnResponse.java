package org.example.dto;

import org.example.model.engine.Game;

public class TurnResponse {
    String opponentMove;
    String heroMove;
    Game game;

    TurnResponse(Game game, String opponentMove, String heroMove){
        this.opponentMove = opponentMove;
        this.heroMove = heroMove;
        this.game = game;
    }
}
