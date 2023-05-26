package lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inpput = scanner.nextLine().split(" ");
        ArrayDeque<String> data = new ArrayDeque<>();
        Collections.addAll(data, inpput);

        while (data.size() > 1) {
            int firstNum = Integer.parseInt(data.pop());
            String operator = data.pop();
            int secondNum = Integer.parseInt(data.pop());

            if (operator.equals("+")) {
                int result = firstNum + secondNum;
                data.push(String.valueOf(result));
            } else {
                int result = firstNum - secondNum;
                data.push(String.valueOf(result));
            }
        }
        System.out.println(data.peek());
    }
}
