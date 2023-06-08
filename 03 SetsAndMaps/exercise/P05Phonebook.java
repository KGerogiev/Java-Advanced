package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String command = scanner.nextLine();

        boolean startSearching = false;

        while (!command.equals("stop")){
            String[] inputArr = command.split("-");

            if (command.equals("search")){
                startSearching = true;
                command = scanner.nextLine();
                continue;
            }

            if (!startSearching){
                String name = inputArr[0];
                String number = inputArr[1];
                phonebook.put(name, number);

            } else {
                if (phonebook.containsKey(inputArr[0])){
                    System.out.printf("%s -> %s%n", inputArr[0], phonebook.get(inputArr[0]));
                } else {
                    System.out.printf("Contact %s does not exist.%n", inputArr[0]);
                }
            }

            command = scanner.nextLine();

        }
    }
}
