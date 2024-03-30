package org.example.api;

import org.example.dto.TurnResponse;
import org.example.model.engine.Game;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("game")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/new")
    public ResponseEntity<Game> newGame(String playerName) {
        try{
            return ResponseEntity.ok(gameService.startGame(playerName));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "NEW GAME COULD NOT BE CREATED", e);
        }
    }

    @GetMapping("/state")
    public ResponseEntity<Game> gameState() {
        try{
            return ResponseEntity.ok(gameService.game);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "THERE IS NO GAME", e);
        }
    }

    @PostMapping("/action/{action}")
    public ResponseEntity<TurnResponse> action(@PathVariable("action") String action) {
        try{
            return ResponseEntity.ok(gameService.takeAction(action));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "THE IS NO GAME", e);
        }
    }

}
