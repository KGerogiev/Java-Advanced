package exercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillPaternA(matrix, n);
        } else if (pattern.equals("B")) {
            fillPaternB(matrix, n);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillPaternB(int[][] matrix, int n) {
        int startNum = 1;

        for (int col = 0; col < n; col++) {

            if (col % 2 != 0) {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = startNum;
                    startNum++;
                }
            } else {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = startNum;
                    startNum++;
                }
            }
        }
    }

    private static void fillPaternA(int[][] matrix, int n) {
        int starNum = 1;

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = starNum;
                starNum++;
            }
        }
    }
}
