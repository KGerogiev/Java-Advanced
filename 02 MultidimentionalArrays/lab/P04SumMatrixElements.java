package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixData = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixData[0];
        int cols = matrixData[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        // count of rows
        int countOfRows = matrix.length;

        // count of columns
        int countOfColumns = matrix[0].length;

        // sum of all matrix elements
        int sum = 0;

        for (int row = 0; row < countOfRows; row++) {
            for (int col = 0; col < countOfColumns; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(countOfRows);
        System.out.println(countOfColumns);
        System.out.println(sum);
    }
}
