package lab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> firstPlayerDeck = new LinkedHashSet<>(first);

        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>(second);

        for (int i = 0; i < 50; i++) {

            if (firstPlayerDeck.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayerDeck.isEmpty()){
                System.out.println("First player win!");
                return;
            }

            //get the cards form the player
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            int secondPlayerCard = secondPlayerDeck.iterator().next();

            //remove them from the decks
            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            //comapir cards
            if (firstPlayerCard > secondPlayerCard){
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard){
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);

            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }

        }
        if (firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
