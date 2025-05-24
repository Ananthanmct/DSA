package repository;

import model.Game;
import model.User;

import java.util.HashMap;

public class GameDB {
    HashMap<Integer, Game> gameMap;
    public GameDB(){
        this.gameMap = new HashMap<>();
    }


}
