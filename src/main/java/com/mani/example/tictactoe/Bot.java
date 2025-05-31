package com.mani.example.tictactoe;

import com.mani.example.tictactoe.enums.BotDifficultyLevel;
import com.mani.example.tictactoe.enums.PlayerType;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Long id, Symbol symbol,BotDifficultyLevel botDifficultyLevel) {
        super(name, id, symbol, PlayerType.BOT);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
