package com.mani.example.tictactoe;

import com.mani.example.tictactoe.enums.BotDifficultyLevel;
import com.mani.example.tictactoe.enums.PlayerType;
import com.mani.example.tictactoe.factory.BotPlayingStrategyFactory;
import com.mani.example.tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Long id, Symbol symbol,BotDifficultyLevel botDifficultyLevel) {
        super(name, id, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
