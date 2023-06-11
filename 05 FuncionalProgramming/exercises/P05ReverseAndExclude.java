package exercises;

import javax.print.DocFlavor;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        numbersList = numbersList.stream().filter(num -> num % n != 0).collect(Collectors.toList());

        Collections.reverse(numbersList);

       //Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        numbersList.stream().forEach(num -> System.out.print(num + " "));

    }
}
