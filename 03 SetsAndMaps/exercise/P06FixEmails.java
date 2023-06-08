package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();

        while (!command.equals("stop")){

            String name = command;
            String email = scanner.nextLine();

            if (email.endsWith("com") || email.endsWith("uk") || email.endsWith("us")){
                command = scanner.nextLine();
                continue;
            }

            emails.put(name, email);

            command = scanner.nextLine();
        }
        printMap(emails);
    }

    private static void printMap(Map<String, String> emails) {
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
