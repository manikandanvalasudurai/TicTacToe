package com.mani.example.tictactoe.strategy.gamewinningstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Move;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Move move);
}
