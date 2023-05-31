package exercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, int rows, int cols) {
        char startChar = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String current = "" + startChar + (char) (startChar + col) + startChar;
                matrix[row][col] = current;
            }
            startChar = (char) (startChar + 1);
        }
    }
}
