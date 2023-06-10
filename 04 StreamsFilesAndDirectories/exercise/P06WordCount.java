package exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        String pathOne = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathTwo = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        List<String> wordToFind = Files.readAllLines(Path.of(pathOne));

        Map<String, Integer> matches = new HashMap<>();

        for (int i = 0; i < wordToFind.size(); i++) {
            String[] word = wordToFind.get(i).split("\\s+");
            for (String w : word) {
                matches.put(w, 0);
            }
        }

        List<String> linesInText = Files.readAllLines(Path.of(pathTwo));

        for (String line : linesInText){
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (matches.containsKey(words[i])){
                    int currentCount = matches.get(words[i]);
                    matches.put(words[i], currentCount + 1);
                }
            }
        }

        PrintWriter writer = new PrintWriter("F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt");

        matches.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> writer.println(e.getKey() + " - " + e.getValue()));

        writer.close();



    }
}
