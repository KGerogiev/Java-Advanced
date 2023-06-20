package Exam_12April2023;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Целта е да се съберат 3 лешника
        int haselNuts = 0;

        //матрицата винаги ще бъде с еднакви редове и колони
        int size = Integer.parseInt(scanner.nextLine());

        //създавам опашка със движенията на катерицата
        ArrayDeque<String> moves = new ArrayDeque<>();

        //запълвам опашката с данните от конзолата
        String[] inputMoves = scanner.nextLine().split(", ");
        for (int i = 0; i < inputMoves.length; i++) {
            moves.offer(inputMoves[i]);
        }

        //създавам матрицата
        String[][] matrix = new String[size][size];

        // Започвам да запъвам матрицата с данните от конзолата
        for (int i = 0; i < size; i++) {
            String[] currentRow = scanner.nextLine().split("");
            matrix[i] = currentRow;
        }

        //намерим позицията на катерицата
        int squirlRow = -1;
        int squirlCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("s")){
                    squirlRow = row;
                    squirlCol = col;
                    break;
                }
            }
        }

        //създавам булева променлива за предварителен край на играта
        boolean gameOver = false;

        //започвам движението на катерицата

        while (!moves.isEmpty()){
            String currentMove = moves.poll();

            switch (currentMove){

                case "left":
                    //премахвам катерицата от досегашното и място
                    matrix[squirlRow][squirlCol] = "*";
                    //променям координатите на катерицата
                    squirlCol--;
                    //проверявам дали мястото на което отива катерицата е в матрицата
                    if (!isInTheMatrix(squirlRow, squirlCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        gameOver = true;
                        break;
                    }
                    //проверявам какво има на следващата позиция  t, h
                    if (matrix[squirlRow][squirlCol].equals("h")){
                        haselNuts++;
                        if (haselNuts >= 3){
                            System.out.println("Good job! You have collected all hazelnuts!");
                            gameOver = true;
                            break;
                        }
                    } else if (matrix[squirlRow][squirlCol].equals("t")){
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        gameOver = true;
                        break;
                    }
                    break;

                case "right":
                    //премахвам катерицата от досегашното и място
                    matrix[squirlRow][squirlCol] = "*";
                    //променям координатите на катерицата
                    squirlCol++;
                    //проверявам дали мястото на което отива катерицата е в матрицата
                    if (!isInTheMatrix(squirlRow, squirlCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        gameOver = true;
                        break;
                    }
                    //проверявам какво има на следващата позиция  t, h
                    if (matrix[squirlRow][squirlCol].equals("h")){
                        haselNuts++;
                        if (haselNuts >= 3){
                            System.out.println("Good job! You have collected all hazelnuts!");
                            gameOver = true;
                            break;
                        }
                    } else if (matrix[squirlRow][squirlCol].equals("t")){
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        gameOver = true;
                        break;
                    }
                    break;

                case "up":
                    //премахвам катерицата от досегашното и място
                    matrix[squirlRow][squirlCol] = "*";
                    //променям координатите на катерицата
                    squirlRow--;
                    //проверявам дали мястото на което отива катерицата е в матрицата
                    if (!isInTheMatrix(squirlRow, squirlCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        gameOver = true;
                        break;
                    }
                    //проверявам какво има на следващата позиция  t, h
                    if (matrix[squirlRow][squirlCol].equals("h")){
                        haselNuts++;
                        if (haselNuts >= 3){
                            System.out.println("Good job! You have collected all hazelnuts!");
                            gameOver = true;
                            break;
                        }
                    } else if (matrix[squirlRow][squirlCol].equals("t")){
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        gameOver = true;
                        break;
                    }
                    break;

                case "down":
                    //премахвам катерицата от досегашното и място
                    matrix[squirlRow][squirlCol] = "*";
                    //променям координатите на катерицата
                    squirlRow++;
                    //проверявам дали мястото на което отива катерицата е в матрицата
                    if (!isInTheMatrix(squirlRow, squirlCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        gameOver = true;
                        break;
                    }
                    //проверявам какво има на следващата позиция  t, h
                    if (matrix[squirlRow][squirlCol].equals("h")){
                        haselNuts++;
                        if (haselNuts >= 3){
                            System.out.println("Good job! You have collected all hazelnuts!");
                            gameOver = true;
                            break;
                        }
                    } else if (matrix[squirlRow][squirlCol].equals("t")){
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        gameOver = true;
                        break;
                    }

                    break;
            }
            // в случай на капан, събрани лешници или излизане от матрицата
            if (gameOver){
                break;
            }
        }

        if (gameOver){
            System.out.println("Hazelnuts collected: " + haselNuts);
        } else {
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + haselNuts);

        }
    }

    public static boolean isInTheMatrix(int sqirlRow, int squirlCol, int size){
       return sqirlRow >= 0 && sqirlRow < size && squirlCol >= 0 && squirlCol < size;
    }
}
