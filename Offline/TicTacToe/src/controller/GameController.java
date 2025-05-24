package controller;

import model.User;
import service.GameService;
import service.UserService;

import java.util.Scanner;

public class GameController {


    UserService userService;
    GameService gameService;



    public GameController(){
        this.userService = new UserService();
        this.gameService = new GameService();
    }


    public void startProgram(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to TicToe Game !!");
        System.out.println("Let's start game and complete your registration !!");
        System.out.println("Player1: Are you a new user ?(Yes/No)");
        String userResp1 = scn.next();
        User player1;
        User player2;
        if(userResp1.equals("No")){
            while(true){
                System.out.println("Player1: Tell us your userId");
                int id = scn.nextInt();
                User user = userService.validateUserId(id);
                if(user != null){
                    System.out.println("Correct id entered");
                    player1 = user;
                    break;
                }
                System.out.println("Player1: Wrong Id entered !!");
            }
        }else{
           System.out.println("Player1: Enter your name")
        }
    }
}
