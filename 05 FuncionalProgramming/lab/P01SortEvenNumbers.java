package lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                 .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isEven = number -> number % 2 == 0;
        numbers = numbers.stream().filter(isEven).collect(Collectors.toList());

        printWihtComa(numbers);
        Collections.sort(numbers);
        printWihtComa(numbers);

    }

    private static void printWihtComa(List<Integer> numbers) {
        List <String> result = new ArrayList<>();
        numbers.forEach(e -> result.add(e.toString()));
        System.out.println(String.join(", ", result));
    }
}
