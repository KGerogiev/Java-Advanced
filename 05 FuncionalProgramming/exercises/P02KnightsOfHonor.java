package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<List<String>> print = text -> {
            for (String word : text){
                word = "Sir " + word;
                System.out.println(word);
            }
        };
        print.accept(words);
    }
}
