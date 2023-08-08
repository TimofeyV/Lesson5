// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Homework {

    /**
     * Дан текст. Нужно отсортировать слова по длине (по возрастанию) и вывести статистику на экран.
     * Регистр слова не имеет значения. Формат вывода произвольный.
     * Программа-минимум:
     * 1. Слова, состоящие из дефисов, считаем одним словом. Т.е. каких-то - одно слово из 8 символов.
     * 2. Точки и запятые не должны входить в статистику.
     *
     * Доп. задание
     * 1. * Не включать дефис в длину слова. Т.е. каких-то - одно слово из 7 символов.
     *
     * Пример:
     *
     * Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB.
     * Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.
     *
     * 1 -> [и, в]
     * 2 -> [он, из, gb, не]
     * 3 -> [мой, для]
     * 4 -> [слов, того, себе]
     * 5 -> [текст, нужен, чтобы, несет, набор]
     * ...
     */
    static void printStats(String text) {
        // 1. Split текста, приведение его к нижнему регистру, удаление запятых и точек.
        text = text.replaceAll("[^а-яА-Я a-zA-Z-]", "").toLowerCase();
        String[] words = text.split(" ");
        int max = 0;
        for (String word: words){
            if (word.length() > max) max = word.length();
        }
        // 2. Сбор структуры со статистикой.
        Map<Integer, List<String>> stats = new HashMap<>(); // Структура, в которой ключ - длина слова, значение - список таких слов.
        for (int i = 1; i < max; i++) {
            ArrayList<String> stat = new ArrayList<String>();
            for (String word : words) {
                int count = word.length();
                if (word.contains("-")) {
                    count -= 1;
                }
                if(count == i && !stat.contains(word)){
                    stat.add(word);
                }
            }
            stats.putIfAbsent(i, stat);
        }
        for (Integer key: stats.keySet()) {
            System.out.printf("%d -> %s\n", key, stats.get(key));
        }

    }

    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB. " +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        printStats(text);
    }
}