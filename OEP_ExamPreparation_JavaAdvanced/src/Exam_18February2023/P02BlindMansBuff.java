package Exam_18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //размери на матрицата
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowsMatrix = dimentions[0];
        int colMatrix = dimentions[1];

        //създавам матрицата
        String[][] matrix = new String[rowsMatrix][colMatrix];

        //запълвам матрицата
        for (int i = 0; i < rowsMatrix; i++) {
            String[] row = scanner.nextLine().split(" ");
            matrix[i] = row;
        }

        // намирам началната позиция на човечето -> "В"
        int blindRow = -1;
        int blindCol = -1;
        for (int row = 0; row < rowsMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                if (matrix[row][col].equals("B")) {
                    blindRow = row;
                    blindCol = col;
                    break;
                }
            }
        }

        // започвам движението

        String command = scanner.nextLine(); // "up", " down", "right", and "left", "Finish"

        int countTouchedPlayers = 0;
        int countMoves = 0;
        boolean gameOver = false;

        while (!command.equals("Finish")) {

            switch (command) {

                case "up":
                    //излизам от полето
                    if (!isInTheRange(blindRow - 1, blindCol, rowsMatrix, colMatrix)) {
                        command = scanner.nextLine();
                        continue;
                    }
                    // проверявам дали там, където отивам има препятствие -> "O"
                    if (matrix[blindRow - 1][blindCol].equals("O")) {
                        // не правя хода и чакам следваща команда
                        command = scanner.nextLine();
                        continue;
                    }
                    // не излизам от полето и няма препядствие -> правя хода
                    // слагам тире там, където съм бил
                    matrix[blindRow][blindCol] = "-";
                    //проверявам има ли играч там, където отивам -> "P"
                    if (matrix[blindRow - 1][blindCol].equals("P")) {
                        // попадам на играч
                        countTouchedPlayers++;
                        countMoves++;
                        if (countTouchedPlayers == 3){
                            gameOver = true;
                            blindRow--;
                            break;
                        }
                    }
                    // проверявам дали там, където отивам има тире
                    if (matrix[blindRow - 1][blindCol].equals("-")) {
                        countMoves++;
                    }
                    blindRow--;

                    break;
                case "down":
                    //излизам от полето
                    if (!isInTheRange(blindRow + 1, blindCol, rowsMatrix, colMatrix)) {
                        command = scanner.nextLine();
                        continue;
                    }
                    // проверявам дали там, където отивам има препятствие -> "O"
                    if (matrix[blindRow + 1][blindCol].equals("O")) {
                        // не правя хода и чакам следваща команда
                        command = scanner.nextLine();
                        continue;
                    }
                    // не излизам от полето и няма препядствие -> правя хода
                    // слагам тире там, където съм бил
                    matrix[blindRow][blindCol] = "-";
                    //проверявам има ли играч там, където отивам -> "P"
                    if (matrix[blindRow + 1][blindCol].equals("P")) {
                        // попадам на играч
                        countTouchedPlayers++;
                        countMoves++;
                        if (countTouchedPlayers == 3){
                            gameOver = true;
                            blindRow++;
                            break;
                        }
                    }
                    // проверявам дали там, където отивам има тире
                    if (matrix[blindRow + 1][blindCol].equals("-")) {
                        countMoves++;
                    }
                    blindRow++;

                    break;
                case "right":
                    //излизам от полето
                    if (!isInTheRange(blindRow, blindCol + 1, rowsMatrix, colMatrix)) {
                        command = scanner.nextLine();
                        continue;
                    }
                    // проверявам дали там, където отивам има препятствие -> "O"
                    if (matrix[blindRow][blindCol + 1].equals("O")) {
                        // не правя хода и чакам следваща команда
                        command = scanner.nextLine();
                        continue;
                    }
                    // не излизам от полето и няма препядствие -> правя хода
                    // слагам тире там, където съм бил
                    matrix[blindRow][blindCol] = "-";
                    //проверявам има ли играч там, където отивам -> "P"
                    if (matrix[blindRow][blindCol + 1].equals("P")) {
                        // попадам на играч
                        countTouchedPlayers++;
                        countMoves++;
                        if (countTouchedPlayers == 3){
                            gameOver = true;
                            blindCol++;
                            break;
                        }
                    }
                    // проверявам дали там, където отивам има тире
                    if (matrix[blindRow][blindCol + 1].equals("-")) {
                        countMoves++;
                    }
                    blindCol++;

                    break;
                case "left":
                    //излизам от полето
                    if (!isInTheRange(blindRow, blindCol - 1, rowsMatrix, colMatrix)) {
                        command = scanner.nextLine();
                        continue;
                    }
                    // проверявам дали там, където отивам има препятствие -> "O"
                    if (matrix[blindRow][blindCol - 1].equals("O")) {
                        // не правя хода и чакам следваща команда
                        command = scanner.nextLine();
                        continue;
                    }
                    // не излизам от полето и няма препядствие -> правя хода
                    // слагам тире там, където съм бил
                    matrix[blindRow][blindCol] = "-";
                    //проверявам има ли играч там, където отивам -> "P"
                    if (matrix[blindRow][blindCol - 1].equals("P")) {
                        // попадам на играч
                        countTouchedPlayers++;
                        countMoves++;
                        if (countTouchedPlayers == 3){
                            gameOver = true;
                            blindCol--;
                            break;
                        }
                    }
                    // проверявам дали там, където отивам има тире
                    if (matrix[blindRow][blindCol - 1].equals("-")) {
                        countMoves++;
                    }
                    blindCol--;
                    break;

            }

            //отбелявам текущата позиция на играча
            matrix[blindRow][blindCol] = "B";

            if (gameOver){
                break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", countTouchedPlayers, countMoves);
    }

    public static boolean isInTheRange(int row, int col, int matrixRows, int matrixCols) {
        return row >= 0 && row < matrixRows && col >= 0 && col < matrixCols;
    }

}
