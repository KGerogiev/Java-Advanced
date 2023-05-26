package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        char[] data = input.toCharArray(); // [1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5]

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < data.length; i++) {
            char ch = data[i];
            if (ch == '(') {
                int startIndex = i;
                indexStack.push(startIndex);
            } else if (ch == ')') {
                int endIndex = i;
                int startIndex = indexStack.pop();
                String substring = input.substring(startIndex, endIndex + 1);
                System.out.println(substring);
            }
        }
    }
}
