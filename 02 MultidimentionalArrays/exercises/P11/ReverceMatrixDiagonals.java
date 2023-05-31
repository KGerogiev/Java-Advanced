package exercises.P11;

import java.lang.reflect.Array;
import java.util.*;

public class ReverceMatrixDiagonals {
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

        for (int col = cols - 1; col >= 0; col--) {
            int row = matrix.length - 1;
            int k = col;
            while (k <= cols - 1) {
                int currentElement = matrix[row][k];
                System.out.print(currentElement + " ");
                k++;
                row--;
                if (row < 0){
                    break;
                }
            }
            System.out.println();
        }

        for (int row = matrix.length - 2;  row >= 0; row--) {
            int col = 0;
            int k = row;
            while (k >= 0) {
                int currentElement = matrix[k][col];
                System.out.print(currentElement + " ");
                k--;
                col++;
            }
            System.out.println();
        }
    }
}

