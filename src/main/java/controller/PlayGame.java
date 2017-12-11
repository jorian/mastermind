package controller;

import model.Game;
import view.Console;

public class PlayGame {
    public void play(Game a_game, Console a_view) {

        a_view.displayInstructions();

        while (!a_game.gameOver()) {
            System.out.println("\nTake a guess:");
            System.out.printf("[%s]\n",a_game.evaluateGuess(a_view.getCode()).toString());
        }
    }
}
