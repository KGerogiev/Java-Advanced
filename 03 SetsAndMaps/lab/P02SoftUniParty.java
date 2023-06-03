package lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {

            String nextGuest = input;

            // check if input = 8 chars
            if (nextGuest.length() != 8) {
                input = scanner.nextLine();
                continue;
            }

            // check if the guest is VIP
            if (isVip(nextGuest)) {
                vipGuests.add(nextGuest);

            } else {
            //check if the guest is regular
                regularGuests.add(nextGuest);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            String guest = input;

            vipGuests.remove(guest);
            regularGuests.remove(guest);

            input = scanner.nextLine();
        }

            System.out.println(vipGuests.size() + regularGuests.size());
            vipGuests.forEach(System.out::println);
            regularGuests.forEach(System.out::println);

    }

    private static boolean isVip(String nextGuest) {
        char firstChar = nextGuest.toCharArray()[0];
        return Character.isDigit(firstChar);
    }
}
