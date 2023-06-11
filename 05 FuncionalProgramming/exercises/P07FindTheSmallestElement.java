package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNum = number -> {
            int minNumber = Integer.MAX_VALUE;
            for (Integer num : number) {
                if (num < minNumber) {
                    minNumber = num;
                }
            }
            return minNumber;
        };

        int smallestNumber = smallestNum.apply(numbersList);
        System.out.println(returnIndexOfSmallest(smallestNumber, numbersList));

    }
    private static int returnIndexOfSmallest (int num, List<Integer> collection){
        int surchedIndex = -1;
        for (int i = collection.size() - 1; i >= 0; i--) {
            int currentNum = collection.get(i);
            if (currentNum == num){
                surchedIndex = i;
                break;
            }
        }
        return surchedIndex;
    }
}
