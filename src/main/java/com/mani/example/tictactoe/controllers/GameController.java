package com.mani.example.tictactoe.controllers;

import com.mani.example.tictactoe.Game;
import com.mani.example.tictactoe.Move;
import com.mani.example.tictactoe.Player;
import com.mani.example.tictactoe.enums.GameState;
import com.mani.example.tictactoe.exceptions.BotCountException;
import com.mani.example.tictactoe.exceptions.DuplicateSymbolFoundException;
import com.mani.example.tictactoe.exceptions.InvalidPlayerCountException;

import java.util.List;

public class GameController {
    public static Game startGame(int dimension, List<Player> players) throws BotCountException, InvalidPlayerCountException, DuplicateSymbolFoundException {
        return Game.getBuilder().setDimention(dimension).setPlayers(players).build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) {

    }
    public void displayBoard(Game game) {
        game.displayBoard();
    }
    public GameState getGameState(Game game) {
        return game.getGameState();
    }
}
