package com.mani.example.tictactoe;

import com.mani.example.tictactoe.enums.PlayerType;
import com.mani.example.tictactoe.exceptions.BotCountException;
import com.mani.example.tictactoe.exceptions.DuplicateSymbolFoundException;
import com.mani.example.tictactoe.exceptions.InvalidPlayerCountException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerMoveIndex;

    private Game(int dimension,List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
    }
    public static Builder getBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public void displayBoard() {
        board.printBoard();
    }

    public static class Builder {
        //Not all Attributes required like conventional Builder
        //REASON is
        //To build the Game Size ,List of the Board is Enough since I don't want to expose details to the client
        //Unlike Making Student object
        private int dimention;
        private List<Player> players;

        public int getDimention() {
            return dimention;
        }

        public Builder setDimention(int dimention) {
            this.dimention = dimention;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void validateCount() throws InvalidPlayerCountException {
            if(players.size() != dimention-1){
                throw new InvalidPlayerCountException("Players should be One less than the Dimention of the Board");
            }

        }
        private void validateUniqueSymbol() throws DuplicateSymbolFoundException {
            Map<Character,Integer> symbolMap = new HashMap<>();

            for(Player player : players){
                char symbolCount = player.getSymbol().getaChar();
                if(!symbolMap.containsKey(symbolCount)){
                    symbolMap.put(symbolCount,1);
                }
                else{
                    symbolMap.put(symbolCount,symbolMap.get(symbolCount)+1);
                }
                if(symbolMap.get(symbolCount) > 1){
                    throw new DuplicateSymbolFoundException("Symbol is Already Taken");
                }
            }
        }
        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
                if(botCount > 1){
                    throw new BotCountException("Only one Bot is Allowed per Game");
                }
            }
        }
        private void validateGame(int dimention, List<Player> players) throws InvalidPlayerCountException, DuplicateSymbolFoundException, BotCountException {
            validateCount();
            validateUniqueSymbol(); //No two player should pick same
            validateBotCount();
        }

        public Game build() throws InvalidPlayerCountException, DuplicateSymbolFoundException, BotCountException {
            //VALIDATIONS
            validateGame(dimention,players);
            return new Game(
                    dimention,
                    players
            );
        }
    }
}
