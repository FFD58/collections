package ru.fafurin.lesson5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

// Урок 7. HashSet, LinkedHashSet
public class Main {
    public static void main(String[] args) {
// Возьмите любую цитату, запишите её в файл и попробуйте прочитать её посчитав количество уникальных слов в тексте.
        String quote = "За свою карьеру я пропустил более 9000 бросков, проиграл почти 300 игр. 26 раз мне доверяли сделать финальный победный бросок, и я промахивался. Я терпел поражения снова, и снова, и снова. И именно поэтому я добился успеха. Майкл Джордан";
        System.out.println(countUniqueWordsNumberInFile(saveStringToFile(quote)));
    }

    private static int countUniqueWordsNumberInFile(String filename) {
        List<String> words = List.of(getFileContent(filename).split(" "));
        HashSet<String> set = new HashSet<>(words);
        return set.size();
    }

    private static String saveStringToFile(String str) {
        String filename = "quote.txt";
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return filename;
    }

    private static String getFileContent(String filename) {
        Path path = Paths.get(filename);
        String text = null;
        try {
            text = Files.readString(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return text;
    }
}
