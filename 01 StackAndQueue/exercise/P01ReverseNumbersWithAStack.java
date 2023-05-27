package exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer :: parseInt).forEach(numbers :: push);

        for (Integer tokens : numbers) {
            System.out.print(tokens + " ");
        }
    }
}
