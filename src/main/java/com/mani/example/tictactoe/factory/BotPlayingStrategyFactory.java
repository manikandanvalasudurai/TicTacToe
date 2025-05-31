package com.mani.example.tictactoe.factory;

import com.mani.example.tictactoe.enums.BotDifficultyLevel;
import com.mani.example.tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;
import com.mani.example.tictactoe.strategy.botplayingstrategy.EasyBotPlayingStrategy;
import com.mani.example.tictactoe.strategy.botplayingstrategy.HardBotPlayingStrategy;
import com.mani.example.tictactoe.strategy.botplayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            case HARD:
                return new HardBotPlayingStrategy();
        }
        return null;
    }
}
