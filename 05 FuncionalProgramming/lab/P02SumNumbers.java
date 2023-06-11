package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // входът с чилсата

        Function<String, Integer> sumFunction = text -> {
            int sum = 0;
            List<Integer> numbers = Arrays.stream(text.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
            for (Integer num : numbers){
                sum += num;
            }
            return sum;
        };

        int countNumbers = input.split(", ").length;
        int sum = sumFunction.apply(input);

        System.out.println("Count = " + countNumbers);
        System.out.println("Sum = " + sum);
    }
}
