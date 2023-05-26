package lab;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> data = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                //back
                if (data.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    data.pop();
                    String currentUrl = data.peek();
                    System.out.println(currentUrl);
                }
            } else {
                //url
                String currentUrl = input;
                data.push(input);
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
