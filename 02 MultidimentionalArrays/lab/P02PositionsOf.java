package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer :: parseInt)
                .toArray();
        int [][] matrix = new int[data[0]][data[1]];

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < data[1]; cols++) {
                if (matrix[rows][cols] == number){
                    System.out.println(rows + " " + cols);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
