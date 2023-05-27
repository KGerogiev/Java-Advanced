package exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
        int n = tokens[0];
        int s = tokens[1];
        int x = tokens[2];

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).forEach(numbersStack :: push);

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }
        if (numbersStack.isEmpty()){
            System.out.println(0);
            return;
        }
        if (numbersStack.contains(x)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersStack));
        }
    }
}
