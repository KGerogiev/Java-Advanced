package Exam_22October2022;

import java.util.*;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] firstLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int [] secondLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> mgCaffeine = new ArrayDeque<>();
        for (int i = 0; i < firstLine.length; i++) {
            mgCaffeine.push(firstLine[i]);
        }
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        for (int i = 0; i < secondLine.length; i++) {
            energyDrinks.offer(secondLine[i]);
        }

        int currentStamatCofein = 0;  //макс 300

        while (!mgCaffeine.isEmpty() && !energyDrinks.isEmpty()){
            int cafeine = mgCaffeine.peek();
            int drink = energyDrinks.peek();
            int sum = cafeine * drink;

            if (currentStamatCofein + sum <= 300){
                mgCaffeine.pop();
                energyDrinks.poll();
                currentStamatCofein += sum;
            } else {
                mgCaffeine.pop();
                drink = energyDrinks.poll();
                energyDrinks.offer(drink);
                currentStamatCofein -= 30;
                if (currentStamatCofein < 0){
                    currentStamatCofein = 0;
                }
            }
        }
        if (!energyDrinks.isEmpty()){
            List<String> remaningDrinks = new ArrayList<>();
            for (Integer drink : energyDrinks){
                remaningDrinks.add(String.valueOf(drink));
            }
            System.out.printf("Drinks left: %s%n", String.join(", ", remaningDrinks));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", currentStamatCofein);

    }
}
