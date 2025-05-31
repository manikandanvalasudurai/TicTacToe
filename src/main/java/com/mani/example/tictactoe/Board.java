package com.mani.example.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int dimention) {
        this.size = dimention;
        this.board = new ArrayList<>();
        for(int i=0;i<size;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i,j)); // [[cell] [cell] [cell]]
            }                                    // [[cell] [cell] [cell]]
        }                                        // [[cell] [cell] [cell]]
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
    public void printBoard() {
        for(List<Cell> row : board){
            for(Cell cell : row){
                if (cell.isEmpty()) {
                    System.out.print("|  |");
                }
                else {
                    char symbol = cell.getPlayer().getSymbol().getaChar();
                    System.out.print("| " + symbol + " |");
                }
            }
            System.out.println();
        }
    }
}
