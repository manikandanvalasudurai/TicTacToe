package com.mani.example.tictactoe.strategy.botplayingstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
