package exercise;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathIn = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\outputCountChars.txt";

        int vowels = 0;
        int symbols = 0;
        int punctMarks = 0;

        BufferedReader br = new BufferedReader(new FileReader(pathIn));
        String line = br.readLine();

        while (line != null) {

            for (int symbol = 0; symbol < line.length(); symbol++) {
                char currentSymbol = line.charAt(symbol);

                if (currentSymbol == ' '){
                    continue;
                }

                if (isVowel(currentSymbol)) {
                    vowels++;
                } else if (isPunctuation(currentSymbol)) {
                    punctMarks++;
                } else {
                    symbols++;
                }
            }

            line = br.readLine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut));
        writer.write("Vowels: " + vowels);
        writer.newLine();
        writer.write("Other symbols: " + symbols);
        writer.newLine();
        writer.write("Punctuation: " + punctMarks);

        writer.close();

    }

    private static boolean isPunctuation(char currentSymbol) {
        Set<Character> punktMarks = new HashSet<>();
        punktMarks.add('!');
        punktMarks.add(',');
        punktMarks.add('.');
        punktMarks.add('?');
        return punktMarks.contains(currentSymbol);
    }

    private static boolean isVowel(char currentSymbol) {
        Set<Character> chars = new HashSet<>();
        chars.add('a');
        chars.add('e');
        chars.add('o');
        chars.add('u');
        chars.add('i');
        return chars.contains(currentSymbol);
    }


}
