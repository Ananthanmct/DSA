package repository;

import model.User;

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
}
