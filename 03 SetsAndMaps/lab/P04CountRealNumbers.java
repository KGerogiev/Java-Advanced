package lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double[] numbers = Arrays.stream(input.split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurence = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double nextNum = numbers[i];

            if (occurence.containsKey(nextNum)){
                occurence.put(nextNum, occurence.get(nextNum) + 1);
            } else {
                occurence.put(nextNum, 1);
            }

        }
        occurence.entrySet().forEach(entry -> System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue()));

    }
}
