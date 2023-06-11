package exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> smallest = num -> {
            int smallestNum = Integer.MAX_VALUE;
            for (Integer i : num) {
                if (i < smallestNum){
                    smallestNum = i;
                }
            }
            return smallestNum;
        };

        System.out.println(smallest.apply(numbers));

    }
}
