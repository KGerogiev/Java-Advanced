package Exam_22October2022;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            matrix[i] = row;
        }

        int carRow = 0;
        int carCol = 0;
        int countKm = 0;
        boolean finish = false;

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.equals("right")) {
                //слагам точка на мястото на което съм бил
                matrix[carRow][carCol] = ".";
                //местя колата
                carCol++;
                //проверявам дали на мястото на което местя колата има точка -> "."
                if (matrix[carRow][carCol].equals(".")) {
                    countKm += 10;
                }
                //проверявам дали на мястото на което съм преместил колата има финал -> "F"
                if (matrix[carRow][carCol].equals("F")) {
                    countKm += 10;
                    finish = true;
                    break;
                }
                //проверявам дали на мястото на което съм преместил колата има тунел -> "Т"
                if (matrix[carRow][carCol].equals("T")) {
                    //слагам точка на мястото на тунела
                    matrix[carRow][carCol] = ".";
                    countKm += 30;
                    //намирам другият край на тунела и слагам колата там
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (matrix[row][col].equals("T")) {
                                carRow = row;
                                carCol = col;
                                break;
                            }
                        }
                    }
                    //слагам точка на мястото на края на тунела
                    matrix[carRow][carCol] = ".";
                }

            } else if (command.equals("left")) {
                //слагам точка на мястото на което съм бил
                matrix[carRow][carCol] = ".";
                //местя колата
                carCol--;
                //проверявам дали на мястото на което местя колата има точка -> "."
                if (matrix[carRow][carCol].equals(".")) {
                    countKm += 10;
                }
                //проверявам дали на мястото на което съм преместил колата има финал -> "F"
                if (matrix[carRow][carCol].equals("F")) {
                    countKm += 10;
                    finish = true;
                    break;
                }
                //проверявам дали на мястото на което съм преместил колата има тунел -> "Т"
                if (matrix[carRow][carCol].equals("T")) {
                    //слагам точка на мястото на тунела
                    matrix[carRow][carCol] = ".";
                    countKm += 30;
                    //намирам другият край на тунела и слагам колата там
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (matrix[row][col].equals("T")) {
                                carRow = row;
                                carCol = col;
                                break;
                            }
                        }
                    }
                    //слагам точка на мястото на края на тунела
                    matrix[carRow][carCol] = ".";
                }

            } else if (command.equals("up")) {
                //слагам точка на мястото на което съм бил
                matrix[carRow][carCol] = ".";
                //местя колата
                carRow--;
                //проверявам дали на мястото на което местя колата има точка -> "."
                if (matrix[carRow][carCol].equals(".")) {
                    countKm += 10;
                }
                //проверявам дали на мястото на което съм преместил колата има финал -> "F"
                if (matrix[carRow][carCol].equals("F")) {
                    countKm += 10;
                    finish = true;
                    break;
                }
                //проверявам дали на мястото на което съм преместил колата има тунел -> "Т"
                if (matrix[carRow][carCol].equals("T")) {
                    //слагам точка на мястото на тунела
                    matrix[carRow][carCol] = ".";
                    countKm += 30;
                    //намирам другият край на тунела и слагам колата там
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (matrix[row][col].equals("T")) {
                                carRow = row;
                                carCol = col;
                                break;
                            }
                        }
                    }
                    //слагам точка на мястото на края на тунела
                    matrix[carRow][carCol] = ".";
                }

            } else if (command.equals("down")) {
                //слагам точка на мястото на което съм бил
                matrix[carRow][carCol] = ".";
                //местя колата
                carRow++;
                //проверявам дали на мястото на което местя колата има точка -> "."
                if (matrix[carRow][carCol].equals(".")) {
                    countKm += 10;
                }
                //проверявам дали на мястото на което съм преместил колата има финал -> "F"
                if (matrix[carRow][carCol].equals("F")) {
                    countKm += 10;
                    finish = true;
                    break;
                }
                //проверявам дали на мястото на което съм преместил колата има тунел -> "Т"
                if (matrix[carRow][carCol].equals("T")) {
                    //слагам точка на мястото на тунела
                    matrix[carRow][carCol] = ".";
                    countKm += 30;
                    //намирам другият край на тунела и слагам колата там
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (matrix[row][col].equals("T")) {
                                carRow = row;
                                carCol = col;
                                break;
                            }
                        }
                    }
                    //слагам точка на мястото на края на тунела
                    matrix[carRow][carCol] = ".";
                }
            }

            if (finish) {
                break;
            }

            command = scanner.nextLine();
        }

        if (finish) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", countKm);

        matrix[carRow][carCol] = "C";

        printMatrix(matrix, size);

    }

    public static void printMatrix(String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
