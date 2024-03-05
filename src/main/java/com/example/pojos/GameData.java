package com.example.pojos;

public class GameData {

    String encodedWord;

    boolean correctGuess;

    public GameData(String encodedWord, boolean correctGuess) {
        this.encodedWord = encodedWord;
        this.correctGuess = correctGuess;
    }

    public String getEncodedWord() {
        return encodedWord;
    }

    public boolean isCorrectGuess() {
        return correctGuess;
    }
}
