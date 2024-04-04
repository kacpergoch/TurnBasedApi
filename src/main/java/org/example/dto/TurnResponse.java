package org.example.dto;

import org.example.model.engine.Game;

public class TurnResponse implements Response{
    public String heroMove;
    public String opponentMove;
    public Game game;

    public TurnResponse(Game game, String opponentMove, String heroMove){
        this.heroMove = heroMove;
        this.opponentMove = opponentMove;
        this.game = game;
    }
}
