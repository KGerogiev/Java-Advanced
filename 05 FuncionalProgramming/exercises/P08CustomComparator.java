package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNums = input.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNums = input.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());

        evenNums = evenNums.stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());
        oddNums = oddNums.stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());

        System.out.println(String.join(" ", mergeLists(evenNums, oddNums)));

    }
    private static List<String> mergeLists(List<Integer> first, List<Integer> second){
        List<String> mergedList = new ArrayList<>();
        for (Integer num : first) {
            mergedList.add(String.valueOf(num));
        }
        for (Integer num : second) {
            mergedList.add(String.valueOf(num));
        }
        return mergedList;
    }
}
