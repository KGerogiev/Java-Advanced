package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine(); //Rotate(90)
        ArrayList<String> text = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("END")) {

            text.add(command);

            command = scanner.nextLine();
        }

        // проверявам най - дългият ред
        int biggestLine = 0;
        for (int lines = 0; lines < text.size(); lines++) {
            int currentLenth = text.get(lines).length();
            if (currentLenth > biggestLine) {
                biggestLine = currentLenth;
            }
        }

        //създавам чар матрица с редове => text.size и колони => biggestLine;
        char[][] matrix = new char[text.size()][biggestLine];

        //напълвам матрицата
        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = text.get(row).toCharArray();
            for (int i = 0; i < matrix[row].length; i++) {
                if (i >= currentRow.length) {
                    matrix[row][i] = ' ';
                } else {
                    matrix[row][i] = currentRow[i];
                }
            }
        }
        // определям ъгъла на завъртане
        String number = "";
        char[] rotArr = rotation.toCharArray();
        for (int i = 0; i < rotArr.length; i++) {
            if (Character.isDigit(rotArr[i])) {
                number += rotArr[i];
            }

        }
        int degreeOfRotarion = Integer.parseInt(number);

        // създавам втора, ротирана матрица

        // => при ротация на 90
        if (degreeOfRotarion % 360 == 90) {

            char[][] rotated90 = new char[biggestLine][text.size()];
            matrixRotate90(matrix, rotated90, biggestLine, text.size());
            printMatrix(rotated90);

            // => при ротация на 180
        } else if (degreeOfRotarion % 360 == 180) {

            char[][] rotated180 = new char[text.size()][biggestLine];
            matrixRotate180(matrix, rotated180, biggestLine, text.size());
            printMatrix(rotated180);

            // => при ротация на 270
        } else if (degreeOfRotarion % 360 == 270) {

            char[][] rotated270 = new char[biggestLine][text.size()];
            matrixRotate270(matrix, rotated270, biggestLine, text.size());
            printMatrix(rotated270);

            // => при ротация на 360
        } else if (degreeOfRotarion % 360 == 0) {

            printMatrix(matrix);
        }
    }

    private static void matrixRotate270(char[][] matrix, char[][] rotated270, int biggestLine, int size) {

        for (int row = 0; row < size; row++) {
            for (int col = biggestLine - 1; col >= 0; col--) {
                rotated270[biggestLine - 1 - col][row] = matrix[row][col];
            }
        }
    }

    private static void matrixRotate180(char[][] matrix, char[][] rotated180, int biggestLine, int size) {

        for (int row = size - 1; row >= 0; row--) {
            for (int col = biggestLine - 1; col >= 0; col--) {
                rotated180[size - 1 - row][biggestLine - 1 - col] = matrix[row][col];
            }
        }
    }

    private static void matrixRotate90(char[][] matrix, char[][] rotated90, int biggestLine, int size) {

        for (int col = 0; col < biggestLine; col++) {
            for (int row = 0; row < size; row++) {
                char currentChar = matrix[row][col];
                rotated90[col][size - 1 - row] = currentChar;
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
