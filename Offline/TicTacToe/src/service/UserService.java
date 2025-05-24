package service;

import model.User;
import repository.UserDB;

public class UserService {

    UserDB userDB;
    public UserService(){
        this.userDB = new UserDB();
    }


    public User validateUserId(int id){
       User user =  userDB.getUserById(id);
       return user;
    }

    public User createNewUser(){

    }

}
