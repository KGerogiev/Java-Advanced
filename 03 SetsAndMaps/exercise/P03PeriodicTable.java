package exercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> compounds = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] current = scanner.nextLine().split("\\s+");
            for (int j = 0; j < current.length; j++) {
                compounds.add(current[j]);
            }
        }
        compounds.forEach(e -> System.out.print(e + " "));
    }
}
