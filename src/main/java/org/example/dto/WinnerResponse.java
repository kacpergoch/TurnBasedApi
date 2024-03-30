package org.example.dto;

import org.example.model.engine.Game;

public class WinnerResponse {
    TurnResponse lastTurn;
    WinnerResponse(TurnResponse lastTurn){
        String message = String.format("%s HAS WON THE BATTLE", lastTurn.game.getOpponent().getUnitName());
        this.lastTurn = lastTurn;
    }
}
