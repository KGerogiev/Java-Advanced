package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        //прочитам първата матрица
        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = currentRow[col].charAt(0);
            }
        }

        //прочитам втората матрица
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = currentRow[col].charAt(0);
            }
        }

        // сравнявам матриците
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
