package com.mani.example.tictactoe.strategy.gamewinningstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Move;
import com.mani.example.tictactoe.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStrategy {
    private Map<Symbol, Integer> leftDiagonalMap = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
       int row = move.getCell().getRow();
       int col = move.getCell().getCol();

       Symbol symbol = move.getPlayer().getSymbol();
       //left diagonal
       if(row == col){
           //move is present on left diagonal
           if(!leftDiagonalMap.containsKey(symbol)){
               leftDiagonalMap.put(symbol , 1);
           }
           else{
               leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
           }
               if(leftDiagonalMap.get(symbol) == board.getSize()) return true;
       }
        //right diagonal
       if(row + col == board.getSize() - 1){
           if(!rightDiagonalMap.containsKey(symbol)){
               rightDiagonalMap.put(symbol , 1);
           }
           else{
               rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
           }
           if(rightDiagonalMap.get(symbol) == board.getSize()) return true;
       }
       return false;
    }
}
