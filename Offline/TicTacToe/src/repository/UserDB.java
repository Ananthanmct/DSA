package repository;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserDB {
    HashMap<Integer, User> userMap;
    public UserDB(){
        this.userMap = new HashMap<>();
    }

    public User getUserById(int id){
        User user = this.userMap.get(id);
        return user;
    }

    public User createNewUser(String name){
        User user = new User();
        int size = userMap.size();
        int id = size + 1;
        user.setName(name);
        user.setId(id);
        user.setGames(new ArrayList<>());
        userMap.put(id, user);
        return user;
    }
}
