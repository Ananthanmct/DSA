package service;

import model.Game;
import model.User;
import repository.GameDB;

public class GameService {

    GameDB gameDB;

    public GameService(){
        this.gameDB = new GameDB();
    }

    public Game createGame(User player1, User player2){
        return gameDB.createGame(player1, player2);
    }

    public void startGame(Game game){
        User player1 = game.getUser1();

    }
}
