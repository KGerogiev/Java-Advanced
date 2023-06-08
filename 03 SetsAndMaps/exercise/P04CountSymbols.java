package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

        Map<Character, Integer> occuranses = new TreeMap<>();

        char[] text = input.toCharArray();

        for (int i = 0; i < text.length; i++) {
            char currentChar = text[i];
            if (!occuranses.containsKey(currentChar)){
                occuranses.put(currentChar, 1);
            } else {
                occuranses.put(currentChar, occuranses.get(currentChar) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : occuranses.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
