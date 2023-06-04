package lab;

import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String, String> studetsGrades = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            studetsGrades.put(name, avgGrade(grades));
        }

        printMap(studetsGrades);

    }

    private static void printMap(Map<String, String> studetsGrades) {
        for (Map.Entry<String, String> entry : studetsGrades.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static String avgGrade(double[] grades) {
        double avgGrade = 0;
        for (int count = 0; count < grades.length; count++) {
            avgGrade += grades[count];
        }
        return String.valueOf(avgGrade / grades.length);
    }
}
