package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
            matrix[row] = currentRow;
        }

        // да намеря първият диагонал
        int firstDiagonalSum = findFirstDiagonal(matrix);

        // да намеря вторият диагонал
        int secondDiagonalSum = findSecondDiagonal(matrix, n);

        // отпечатвам разликата
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }

    private static int findSecondDiagonal(int[][] matrix, int cols) {
        int sum = 0;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < cols; row++) {
                if (matrix.length - 1 - row == col){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int findFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
}
