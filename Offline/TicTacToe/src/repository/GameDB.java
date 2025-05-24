package repository;

import model.Board;
import model.Game;
import model.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

public class GameDB {
    HashMap<Integer, Game> gameMap;
    public GameDB(){
        this.gameMap = new HashMap<>();
    }
    public Game createGame(User player1, User player2){
        Game game = new Game();
        game.setBoard(new Board());
        game.setId(gameMap.size() + 1);
        game.setStartingTime(LocalDateTime.now());
        game.setUser1(player1);
        game.setUser2(player2);
        gameMap.put(game.getId(), game);
        return game;
    }
}
