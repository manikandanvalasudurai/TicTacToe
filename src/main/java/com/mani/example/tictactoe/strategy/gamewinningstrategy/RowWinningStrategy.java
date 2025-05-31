package com.mani.example.tictactoe.strategy.gamewinningstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Move;
import com.mani.example.tictactoe.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy{
    private Map<Integer, Map<Symbol,Integer>> rowMap = new HashMap<>();
    // row number    -->    (player symbol --> count of how many times it appeared)
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow(); // Step 1: Get row of current move
        Symbol symbol = move.getPlayer().getSymbol(); // Step 2: Get symbol (X or O)
        // Step 3: If this row has never been used before, initialize map
        if(!rowMap.containsKey(row)){
            rowMap.put(row, new HashMap<>());
        }
        // Step 4: Get the symbol-count map for this row
        Map<Symbol, Integer> currentRowMap = rowMap.get(row);
        // Step 5: If this symbol is new to the row, set count to 1; otherwise, increment count
        if(!currentRowMap.containsKey(symbol)){
            currentRowMap.put(symbol, 1);
        }
        else{
            currentRowMap.put(symbol, currentRowMap.get(symbol) + 1);
        }
        // Step 6: If count reaches board size, player wins
        return currentRowMap.get(symbol) == board.getSize();
    }
}
