package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bordersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int lowBound = bordersList.get(0);
        int upperBound = bordersList.get(1);

        List<Integer> numbersList = new ArrayList<>();
        filtheList(lowBound, upperBound, numbersList);

        String type = scanner.nextLine(); // odd / even
        if (type.equals("odd")) {
            List<Integer> oddList = filterOdd(numbersList);
            print(oddList);
        } else if (type.equals("even")) {
            List<Integer> evenList = filterEven(numbersList);
            print(evenList);
        }

    }

    private static void print(List<Integer> numbers){
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> filterEven(List<Integer> numberList) {
        Predicate<Integer> isEven = e -> e % 2 == 0;
        List<Integer> evenNums = new ArrayList<>();
        for (Integer integer : numberList) {
            if (isEven.test(integer)) {
                evenNums.add(integer);
            }
        }
        return evenNums;
    }

    private static List<Integer> filterOdd(List<Integer> numbersList) {
        Predicate<Integer> isOdd = e -> e % 2 != 0;
        List<Integer> oddNums = new ArrayList<>();
        for (Integer integer : numbersList) {
            if (isOdd.test(integer)) {
                oddNums.add(integer);
            }
        }
        return oddNums;
    }

    private static void filtheList(int lowBound, int upperBound, List<Integer> list) {
        for (int i = lowBound; i <= upperBound; i++) {
            list.add(i);
        }
    }
}
