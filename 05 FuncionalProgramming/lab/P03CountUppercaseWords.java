package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> myWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .filter(word -> {
                                    return Character.isUpperCase(word.charAt(0));
                                })
                               .collect(Collectors.toList());
        System.out.println(myWords.size());
        myWords.forEach(System.out::println);

        /*List<String> upperCaseWords = new ArrayList<>();

        Predicate<String> isUpperCase = word -> {
            return Character.isUpperCase(word.charAt(0));

        };
        for (String word : myWords){
            if (isUpperCase.test(word)){
                upperCaseWords.add(word);
            }
        }
        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);*/

    }
}
