package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11RevertMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row > -1){
            int r = row;
            int k = col;

            while (k < cols && r >= 0){
                System.out.print(matrix[r][k] + " ");
                r--;
                k++;
            }
            col--;
            if (col == - 1){
                col = 0;
                row--;
            }
            System.out.println();
        }

    }
}
