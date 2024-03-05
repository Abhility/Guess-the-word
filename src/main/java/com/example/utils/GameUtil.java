package com.example.utils;

import com.example.pojos.GameData;
import java.util.Arrays;
import java.util.List;

public class GameUtil {

    private GameUtil() {
    }

    public static List<String> getWords() {
        return Arrays.asList("Sunshine", "Bicycle", "Enigma", "Symphony", "Whisker", "Galactic", "Lagoon", "Harmony", "Quasar", "Serendipity", "Kaleidoscope",
            "Nebula", "Umbrella", "Velociraptor", "Zenith", "Ponder", "Bumblebee", "Mirage", "Radiant", "Quixotic");
    }

    public static GameData checkLetterInWord(char ch, String actualWord, String encodedWord) {
        int index = actualWord.indexOf(ch);
        if (index > -1) {
            StringBuilder encodedWordBuilder = new StringBuilder(encodedWord);
            StringBuilder actualWordBuilder = new StringBuilder(actualWord);
            char character = encodedWord.charAt(index);
            if (character != '*') {
                actualWordBuilder.setCharAt(index, '*');
                index = actualWordBuilder.toString().indexOf(ch);
            }
            encodedWordBuilder.setCharAt(index, ch);
            return new GameData(encodedWordBuilder.toString(), true);
        }
        return new GameData(encodedWord, false);
    }

    public static String getEncodedWord(String word) {
        return word.chars()
            .mapToObj(ch -> String.valueOf((char) ch))
            .reduce("", (encodedWord, ch) -> encodedWord + "*");
    }
}
