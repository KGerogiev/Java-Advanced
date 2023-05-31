package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int rows = 0; rows < size; rows++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[rows] = currentRow;
        }

        for (int i = 0; i < size; i++) {
            for (int col = i; col < i + 1; col++) {
                System.out.print(matrix[i][col] + " ");
            }
        }

        System.out.println();

        for (int rows = size - 1; rows >= 0; rows--) {
            System.out.print(matrix[rows][size - 1 - rows] + " ");
        }
    }
}
