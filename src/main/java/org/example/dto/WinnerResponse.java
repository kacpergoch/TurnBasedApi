package org.example.dto;


import org.example.model.units.Unit;

public class WinnerResponse implements Response{
    public Unit winner;
    public String message;
    public TurnResponse lastTurn;
    public WinnerResponse(TurnResponse lastTurn, Unit winner){
        message = String.format("%s HAS WON THE BATTLE", winner.getUnitName());
        this.winner = winner;
        this.lastTurn = lastTurn;
    }
}
