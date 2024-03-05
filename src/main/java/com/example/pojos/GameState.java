package com.example.pojos;

public class GameState {

    private final int lives;

    private int turnCount;

    private boolean winner;

    private boolean gameOver;

    private final String currentWord;

    public GameState(int lives, int turnCount, String currentWord) {
        this.lives = lives;
        this.turnCount = turnCount;
        this.currentWord = currentWord;
    }

    public int getLives() {
        return lives;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public int getTurnsLeft() {
        return lives - turnCount;
    }

    public void increaseTurnCount() {
        turnCount++;
    }
}
