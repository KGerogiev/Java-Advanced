package Exam_18February2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> textTile = new ArrayDeque<>();
        for (int i = 0; i < firstRow.length; i++) {
            textTile.offer(firstRow[i]);
        }

        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        for (int i = 0; i < secondRow.length; i++) {
            medicaments.push(secondRow[i]);
        }

        Map<String, Integer> createdMeds = new TreeMap<>();

        while (!textTile.isEmpty() && !medicaments.isEmpty()) {
            int currentTextTile = textTile.peek();
            int currentMedicament = medicaments.peek();

            int sum = currentTextTile + currentMedicament;

            if (sum == 30) {
                if (!createdMeds.containsKey("Patch")) {
                    createdMeds.put("Patch", 1);
                } else {
                    createdMeds.put("Patch", createdMeds.get("Patch") + 1);
                }
                textTile.poll();
                medicaments.pop();
            } else if (sum == 40) {
                if (!createdMeds.containsKey("Bandage")) {
                    createdMeds.put("Bandage", 1);
                } else {
                    createdMeds.put("Bandage", createdMeds.get("Bandage") + 1);
                }
                textTile.poll();
                medicaments.pop();
            } else if (sum == 100) {
                if (!createdMeds.containsKey("MedKit")) {
                    createdMeds.put("MedKit", 1);
                } else {
                    createdMeds.put("MedKit", createdMeds.get("MedKit") + 1);
                }
                textTile.poll();
                medicaments.pop();
            } else if (sum > 100) {
                if (!createdMeds.containsKey("MedKit")) {
                    createdMeds.put("MedKit", 1);
                } else {
                    createdMeds.put("MedKit", createdMeds.get("MedKit") + 1);
                }
                textTile.poll();
                medicaments.pop();
                //left
                int left = sum - 100;
                int currentMed = medicaments.pop();
                medicaments.push(currentMed + left);
            } else {
                textTile.poll();
                int currentMed = medicaments.pop() + 10;
                medicaments.push(currentMed);
            }
        }

        List<Map.Entry<String, Integer>> orderedItems = new ArrayList<>(createdMeds.entrySet());

        Collections.sort(orderedItems, Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                .thenComparing(Map.Entry<String, Integer>::getKey));

        if (textTile.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textTile.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        for (Map.Entry<String, Integer> entry : orderedItems) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }

        if (!textTile.isEmpty()) {
           List<String> list = new ArrayList<>();
            for (Integer text : textTile) {
                list.add(String.valueOf(text));
            }
            System.out.println("Textiles left: " + String.join(", ", list));
        }
        if (!medicaments.isEmpty()) {
            List<String> list = new ArrayList<>();
            for (Integer text : medicaments) {
                list.add(String.valueOf(text));
            }
            System.out.println("Medicaments left: " + String.join(", ", list));
        }
    }

}
