package com.mani.example.tictactoe.strategy.gamewinningstrategy;

import com.mani.example.tictactoe.Board;
import com.mani.example.tictactoe.Move;
import com.mani.example.tictactoe.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy{
    private Map<Integer, Map<Symbol,Integer>> colMap = new HashMap<>();
    // col number    -->    (player symbol --> count of how many times it appeared)
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol(); // Step 1: Get col of current move
        Symbol symbol = move.getPlayer().getSymbol(); // Step 2: Get symbol (X or O)
        // Step 3: If this col has never been used before, initialize map
        if(!colMap.containsKey(col)){
            colMap.put(col, new HashMap<>());
        }
        // Step 4: Get the symbol-count map for this col
        Map<Symbol, Integer> currentColMap = colMap.get(col);
        // Step 5: If this symbol is new to the col, set count to 1; otherwise, increment count
        if(!currentColMap.containsKey(symbol)){
            currentColMap.put(symbol, 1);
        }
        else{
            currentColMap.put(symbol, currentColMap.get(symbol) + 1);
        }
        // Step 6: If count reaches board size, player wins
        return currentColMap.get(symbol) == board.getSize();
    }
}
