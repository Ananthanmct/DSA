package service;

import repository.GameDB;

public class GameService {

    GameDB gameDB;

    public GameService(){
        this.gameDB = new GameDB();
    }
}
