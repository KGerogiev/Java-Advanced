package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String comand = scanner.nextLine();

        while (!comand.equals("end")){

            if (comand.equals("add")){
                // add 1
               Function<Integer, Integer> addOne = e -> e + 1;
               numbers = numbers.stream().map(num -> addOne.apply(num)).collect(Collectors.toList());

            } else if (comand.equals("multiply")){
                // multiply by 2
                Function<Integer, Integer> multiply = e -> e * 2;
                numbers = numbers.stream().map(num -> multiply.apply(num)).collect(Collectors.toList());

            } else if (comand.equals("subtract")){
                // subtract 1
                Function<Integer, Integer> subract = e -> e - 1;
                numbers = numbers.stream().map(num -> subract.apply(num)).collect(Collectors.toList());

            } else if (comand.equals("print")){
                // print all numbers on a new Line
                Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));
                print.accept(numbers);
                System.out.println();

            }

            comand = scanner.nextLine();
        }
    }
}
