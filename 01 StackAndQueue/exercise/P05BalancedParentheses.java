package exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();  //  {[()]}
        String[] tokens = input.split("");
        ArrayDeque<String> openBark = new ArrayDeque<>();

        boolean isBalanced = true;

        for (String brack : tokens) {
            if (tokens.length % 2 != 0){
                isBalanced = false;
                break;
            }

            switch (brack){
                case "}":
                    String open = openBark.pop();
                    if (!open.equals("{")){
                        isBalanced = false;
                    }
                    break;
                case "]":
                    open = openBark.pop();
                    if (!open.equals("[")){
                        isBalanced = false;
                    }
                    break;
                case ")":
                    open = openBark.pop();
                    if (!open.equals("(")){
                        isBalanced = false;
                    }
                    break;
                default:
                    openBark.push(brack);
                    break;

            }
        }
        if (isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
