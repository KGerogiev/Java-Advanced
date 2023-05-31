package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer :: parseInt).toArray();
        int rowsMatrix = data[0];
        int colsMatrix = data[1];

        int[][] generalMatrix = new int[rowsMatrix][colsMatrix];

        for (int row = 0; row < rowsMatrix; row++) {
            int [] currentRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer ::parseInt).toArray();
            generalMatrix[row] = currentRow;
        }

        int[][] bigest = new int[2][2];

        int sum = 0;

        for (int row = 0; row < rowsMatrix - 1; row++) {

            for (int col = 0; col < colsMatrix - 1 ; col++) {

                int first = generalMatrix[row][col];
                int second = generalMatrix[row] [col + 1];
                int trird = generalMatrix[row + 1][col];
                int four = generalMatrix[row + 1][col + 1];

                int currentSum = first + second + trird + four;

                if (currentSum > sum){
                    sum = currentSum;
                    bigest = new int[][] {
                            {first, second},
                            {trird, four}
                    };
                }
            }
        }

        for (int rows = 0; rows < 2; rows++) {
            for (int cols = 0; cols < 2; cols++) {
                System.out.print(bigest[rows][cols] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);

    }
}
