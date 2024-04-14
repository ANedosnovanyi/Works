package Lesson_5;

import java.util.*;

public class Lesson5 {

    private static String[] wordsArray = {
            "Apatity", "Moskow", "Murmansk", "Vladivostok", "Moskow", "Apatity",
            "Petrozavodsk", "Olenegorsk", "Kaliningrad", "Lissabon", "London", "Kursk",
            "Berlin", "Kursk", "Belgorod", "Kirovsk", "Apatity", "Madrid"
    };

    public static void uniqueWords(String[] wordsArray ){
        List<String> wordsList = Arrays.asList(wordsArray);
        Set<String> uniqueWords = new HashSet<>(wordsList);
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : wordsList) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова:");
        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord + " - " + wordCounts.get(uniqueWord) + " раз");
        }
    }

    public static void uniqueWords() {
        uniqueWords(wordsArray);
    }
}
