package lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //прочитам първата матрица
        int[] firstMatrixData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRows = firstMatrixData[0];
        int firstMatrixCols = firstMatrixData[1];

        //ицицализирам матрицата
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        for (int row = 0; row < firstMatrixRows; row++) {
            String[] curretnRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < firstMatrixCols; col++) {
                firstMatrix[row][col] = Integer.parseInt(curretnRow[col]);
            }
        }

        //прочитам данните за втората матрица
        int[] secondMatrixData = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        int secondMatrixRows = secondMatrixData[0];
        int secondMatrixCols = secondMatrixData[1];

        if (!compairParameters(firstMatrixRows, firstMatrixCols, secondMatrixRows, secondMatrixCols)){
            System.out.println("not equal");
            return;
        }

        //инициализирам матрицата
        int[][] seconMatrix = new int[secondMatrixRows][secondMatrixCols];
        for (int i = 0; i < secondMatrixRows; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            seconMatrix[i] = currentRow;
        }

        boolean areEqual = copairMatrix(firstMatrix, seconMatrix, secondMatrixCols);

        if (areEqual){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean compairParameters(int row1, int col1, int row2, int col2) {
        if (row1 != row2 || col1 != col2){
            return false;
        }
        return true;
    }

    private static boolean copairMatrix(int[][] first, int[][] second, int cols) {
        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < cols; col++) {
                if (first[row][col] != second[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
