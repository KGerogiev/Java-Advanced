package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] curretnRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = curretnRow;
        }

        int sum = 0;
        int[][] bigest = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {

            for (int col = 0; col < cols - 2; col++) {

                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int tird = matrix[row][col + 2];
                int four = matrix[row + 1][col];
                int five = matrix[row + 1][col + 1];
                int six = matrix[row + 1][col + 2];
                int seven = matrix[row + 2][col];
                int eight = matrix[row + 2][col + 1];
                int nine = matrix[row + 2][col + 2];

                int currentSum = first + second + tird + four + five + six + seven + eight + nine;

                if (currentSum > sum) {
                    sum = currentSum;
                    bigest = new int[][]{
                            {first, second, tird},
                            {four, five, six},
                            {seven, eight, nine}
                    };
                }
            }
        }
        System.out.println("Sum = " + sum);
        printMatrix(bigest);
    }
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}


