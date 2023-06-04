package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                                .sorted((left, right) -> right.compareTo(left)).limit(3).collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));

    }
}
