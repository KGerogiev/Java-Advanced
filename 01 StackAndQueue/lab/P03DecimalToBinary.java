package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryCode = new ArrayDeque<>();

        int number = input;

        if (number == 0){
            System.out.println(0);
            return;
        }

        while (number > 0){

            binaryCode.push(number % 2);
            number = number / 2;

        }
        for (Integer integer : binaryCode) {
            System.out.print(integer);
        }
    }
}
