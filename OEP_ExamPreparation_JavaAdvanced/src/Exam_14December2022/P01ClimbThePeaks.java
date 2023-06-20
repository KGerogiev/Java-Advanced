package Exam_14December2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> food = new ArrayDeque<>();
        for (int i = 0; i < firstLine.length; i++) {
            food.push(firstLine[i]);
        }
        ArrayDeque<Integer> stamnia = new ArrayDeque<>();
        for (int i = 0; i < secondLine.length; i++) {
            stamnia.offer(secondLine[i]);
        }

        Map<String, Integer> peaksInfo = new LinkedHashMap<>();
        peaksInfo.put("Vihren", 80);
        peaksInfo.put("Kutelo", 90);
        peaksInfo.put("Banski Suhodol", 100);
        peaksInfo.put("Polezhan", 60);
        peaksInfo.put("Kamenitza", 70);

        ArrayDeque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        ArrayDeque<String> gotOnPeak = new ArrayDeque<>();

        boolean win = false;

        while (!food.isEmpty()) {
            int daylyfood = food.peek();
            int daylystamnia = stamnia.peek();

            int sum = daylyfood + daylystamnia;

            int target = peaksInfo.get(peaks.peek());

            if (sum >= target) {
                gotOnPeak.offer(peaks.poll());
                food.pop();
                stamnia.poll();

            } else {
                food.pop();
                stamnia.poll();
            }
            if (peaks.isEmpty()) {
                win = true;
                break;
            }

        }

        if (win) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!gotOnPeak.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : gotOnPeak) {
                System.out.println(peak);
            }
        }
    }
}
