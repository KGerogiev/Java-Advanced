package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countSymbols = Integer.parseInt(scanner.nextLine());
        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> conditionFilter = line -> {
            String currentName = line;
            return currentName.length() <= countSymbols;
        };

        List<String> passedNames = new ArrayList<>();

        for (String name : namesList){
            if (conditionFilter.test(name)){
                passedNames.add(name);
            }
        }

        passedNames.stream().forEach(name -> System.out.println(name));
    }
}
