package com.mani.example.tictactoe;

import com.mani.example.tictactoe.controllers.GameController;
import com.mani.example.tictactoe.enums.BotDifficultyLevel;
import com.mani.example.tictactoe.enums.GameState;
import com.mani.example.tictactoe.enums.PlayerType;
import com.mani.example.tictactoe.exceptions.BotCountException;
import com.mani.example.tictactoe.exceptions.DuplicateSymbolFoundException;
import com.mani.example.tictactoe.exceptions.InvalidPlayerCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) throws BotCountException, InvalidPlayerCountException, DuplicateSymbolFoundException {
        //playing the game
        //step 1 : create / build the game eventhough with builder patttern
           // Game game = Game.getBuilder().setDimention.setPlayer.build();
           // Exposing much details to the Clients --> Add one More layer of Abstraction
        // what it ..?  -> Game game = Gamecontroller.startGame(); everything will be in startGame() method FACADE DESIGN PATTER
        System.out.println("Welcome to Tic-Tac-Toe!");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Player("MKV",1L,new Symbol('X'), PlayerType.HUMAN));
        players.add(new Bot("BOT",2L,new Symbol('O'), BotDifficultyLevel.EASY));

        Game game = gameController.startGame(3,players);
        while(gameController.getGameState(game).equals(GameState.INPROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);

        }
        //Either Draw / Ended
        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Match Drawn");
        }
        else {
            System.out.println(gameController.getWinner(game).getName() + "has won the game");
        }


    }
}
