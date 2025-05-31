package com.mani.example.tictactoe.strategy.botplayingstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Cell;
import com.mani.example.tictactoe.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells : board.getBoard()){
            for(Cell cell : cells){
                if (cell.isEmpty()){
                    return new Move(
                            null,
                            cell
                    );
                }
            }
        }
        return null;
    }
}
