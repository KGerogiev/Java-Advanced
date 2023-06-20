package Exam_14December2022;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //размер на матрицата (квадратна)
        int size = Integer.parseInt(scanner.nextLine());

        //създавам матрицата
        String[][] matrix = new String[size][size];

        //запълвам матрицата
        for (int row = 0; row < size; row++) {
            String[] nextRow = scanner.nextLine().split("");
            matrix[row] = nextRow;
        }

        //намирам координатите на подводницата
        int subRow = -1;
        int subCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")){
                    subRow = row;
                    subCol = col;
                }
            }
        }

        // посоки на движение на подводницата -> "up", "down", "left" and "right"

        // започвам движението по команди от конзолата
        String command = scanner.nextLine(); // -> "up", "down", "left" and "right"

        boolean gameOver = false;
        int countMines = 0;
        int countShips = 0;

        while (true){
            switch (command){
                case "up":
                    //поставям тире на мястото, където е била
                    matrix[subRow][subCol] = "-";
                    //променям координатите на подводницата
                    subRow--;
                    //проверявам дали движението е в матрицата
                    if (isInTheMatrix(subRow, subCol, size)){
                        if (matrix[subRow][subCol].equals("*")){
                            // попадаме на мина
                            countMines++;
                            if (countMines == 3){
                                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                                gameOver = true;
                                break;
                            }
                        } else if (matrix[subRow][subCol].equals("C")){
                            // попадаме на кораб
                            countShips++;
                            if (countShips == 3){
                                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                                gameOver = true;
                                break;
                            }
                        }
                                            }

                    break;
                case "down":
                    //поставям тире на мястото, където е била
                    matrix[subRow][subCol] = "-";
                    //променям координатите на подводницата
                    subRow++;
                    //проверявам дали движението е в матрицата
                    if (isInTheMatrix(subRow, subCol, size)){
                        if (matrix[subRow][subCol].equals("*")){
                            // попадаме на мина
                            countMines++;
                            if (countMines == 3){
                                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                                gameOver = true;
                                break;
                            }
                        } else if (matrix[subRow][subCol].equals("C")){
                            // попадаме на кораб
                            countShips++;
                            if (countShips == 3){
                                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                                gameOver = true;
                                break;
                            }
                        }

                    }

                    break;
                case "left":
                    //поставям тире на мястото, където е била
                    matrix[subRow][subCol] = "-";
                    //променям координатите на подводницата
                    subCol--;
                    //проверявам дали движението е в матрицата
                    if (isInTheMatrix(subRow, subCol, size)){
                        if (matrix[subRow][subCol].equals("*")){
                            // попадаме на мина
                            countMines++;
                            if (countMines == 3){
                                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                                gameOver = true;
                                break;
                            }
                        } else if (matrix[subRow][subCol].equals("C")){
                            // попадаме на кораб
                            countShips++;
                            if (countShips == 3){
                                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                                gameOver = true;
                                break;
                            }
                        }
                    }

                    break;
                case "right":
                    //поставям тире на мястото, където е била
                    matrix[subRow][subCol] = "-";
                    //променям координатите на подводницата
                    subCol++;
                    //проверявам дали движението е в матрицата
                    if (isInTheMatrix(subRow, subCol, size)){
                        if (matrix[subRow][subCol].equals("*")){
                            // попадаме на мина
                            countMines++;
                            if (countMines == 3){
                                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                                gameOver = true;
                                break;
                            }
                        } else if (matrix[subRow][subCol].equals("C")){
                            // попадаме на кораб
                            countShips++;
                            if (countShips == 3){
                                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                                gameOver = true;
                                break;
                            }
                        }
                    }
                    break;
            }
            //поставям подводницата на новото й място
            matrix[subRow][subCol] = "S";

            if (gameOver){
                break;
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix, size);


    }
    public static boolean isInTheMatrix(int row, int col, int size){
      return row >= 0 && row < size && col >= 0 && col < size;
    }
    public static void printMatrix(String[][] matrix, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
