package lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            //read next input
            String[] input = scanner.nextLine().split("\\s+");

            //get the name and the grade of the student
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            //chek if the student exist and if not, add his score to the list
            if (!students.containsKey(name)) {
                List<Double> nextGrade = new ArrayList<>();
                nextGrade.add(grade);
                students.put(name, nextGrade);
            } else {
                students.get(name).add(grade);
            }

        }
        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double avgGrade = avgGrade(student.getValue());
            System.out.print(student.getKey() + " -> ");
            student.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avgGrade);

        }
    }

    private static double avgGrade(List<Double> grades) {
        double grade = 0;
        for (int i = 0; i < grades.size(); i++) {
            grade += grades.get(i);
        }
        double avgGrade = grade / grades.size();
        return avgGrade;
    }
}
