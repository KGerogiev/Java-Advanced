package exercises;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            matrix[row] = currentRow;
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            //валидирам командите
            if (!isValidCommand(command, rows, cols)) {
                System.out.println("Invalid input!");

            } else {
                //разменям елементите
                int row1 = Integer.parseInt(command.split("\\s+")[1]);
                int col1 = Integer.parseInt(command.split("\\s+")[2]);
                int row2 = Integer.parseInt(command.split("\\s+")[3]);
                int col2 = Integer.parseInt(command.split("\\s+")[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                //принтирам матрицата
                printMatrix(matrix);
            }
            command = scanner.nextLine();
        }
    }
    private static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String command, int rows, int cols) {
        String[] commandArr = command.split("\\s+");

        // да има общо 5 елемента
        if (commandArr.length != 5) {
            return false;
        }

        // да започва със "swap"
        if (!commandArr[0].equals("swap")) {
            return false;
        }

        // да съдържа валидни координати
        int row1 = Integer.parseInt(commandArr[1]); // 0 >= row1 < rows
        int col1 = Integer.parseInt(commandArr[2]); // 0 >= col1 < cols
        int row2 = Integer.parseInt(commandArr[3]); // 0 >= row2 < rows
        int col2 = Integer.parseInt(commandArr[4]); // 0 >= col2 < cols

        if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols) {
            return false;
        }

        return true;
    }
}
