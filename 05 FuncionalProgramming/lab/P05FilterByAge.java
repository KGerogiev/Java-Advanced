package lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peopleMap = new LinkedHashMap<>();

        fillTheMap(peopleMap, countPeople, scanner);

        String condition = scanner.nextLine();
        int ageToCampair = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Map<String, Integer> resultMap = new LinkedHashMap<>();

        if (condition.equals("younger")) {
            Predicate<Integer> isYounger = age -> age <= ageToCampair;
            for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
                if (isYounger.test(entry.getValue())) {
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }

        } else if (condition.equals("older")) {
            Predicate<Integer> isOlder = age -> age >= ageToCampair;
            for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
                if (isOlder.test(entry.getValue())) {
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        printResult(format, resultMap);
    }

    private static void fillTheMap(Map<String, Integer> map, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            String name = data.split(", ")[0];
            int age = Integer.parseInt(data.split(", ")[1]);
            map.put(name, age);
        }
    }

    private static void printResult(String format, Map<String, Integer> resultMap) {
        switch (format) {
            case "name":
                for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                    System.out.println(entry.getKey());
                }
                break;
            case "age":
                for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                    System.out.println(entry.getValue());
                }
                break;
            case "name age":
                for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                break;
        }
    }
}
