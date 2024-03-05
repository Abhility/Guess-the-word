package com.example;

import com.example.pojos.GameData;
import com.example.pojos.GameState;
import com.example.utils.GameUtil;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        List<String> words = GameUtil.getWords();
        int randomIndex = new Random().nextInt(words.size());
        String word = words.get(randomIndex).toLowerCase();
        GameState gameState = new GameState(3, 0, word);
        String encodedWord = GameUtil.getEncodedWord(gameState.getCurrentWord());
        GameData gameData = new GameData(encodedWord, false);
        System.out.println("*****--------------------------Guess the word ----------------------------*****");
        System.out.format("You have: %s lives %n", gameState.getLives());
        System.out.format("Guess the word: %s %n", gameData.getEncodedWord());
        while (!gameState.isGameOver()) {
            System.out.print("Guess a letter : ");
            Scanner sc = new Scanner(System.in);
            char guessedLetter = sc.next().charAt(0);
            gameData = GameUtil.checkLetterInWord(guessedLetter, gameState.getCurrentWord(), gameData.getEncodedWord());
            if (gameData.isCorrectGuess()) {
                System.out.println("Correct guess!!. Keep going!");
                if (gameState.getCurrentWord().equals(gameData.getEncodedWord())) {
                    gameState.setWinner(true);
                    gameState.setGameOver(true);
                }
            } else {
                System.out.println("Incorrect guess!!. Try Harder!");
                gameState.increaseTurnCount();
                if (gameState.getTurnsLeft() <= 0) {
                    gameState.setWinner(false);
                    gameState.setGameOver(true);
                }
            }
            System.out.format("Word: %s %n", gameData.getEncodedWord());
            System.out.format("You have: %s lives left %n", gameState.getTurnsLeft());
        }
        System.out.format("Correct word is : %s %n", gameState.getCurrentWord());
        if (gameState.isWinner()) {
            System.out.println("Congrats!! You won the game!");
        } else {
            System.out.println("Tough Luck!! You lost the game. Try Again!");
        }
    }
}
