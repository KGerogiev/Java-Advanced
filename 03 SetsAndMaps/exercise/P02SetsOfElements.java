package exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        int [] setsLenth = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < setsLenth[0]; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < setsLenth[1]; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> repetedNums = new LinkedHashSet<>();

        for (Integer integer : firstSet) {
            if (!secondSet.add(integer)){
                repetedNums.add(integer);
            }
        }
        repetedNums.forEach(e -> System.out.print(e + " "));
    }
}
