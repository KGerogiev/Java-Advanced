package lab;

import java.util.*;

public class P07CitiesByContinenAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> dataMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] iput = scanner.nextLine().split("\\s+");
            String continent = iput[0];
            String country = iput[1];
            String city = iput[2];

            if (!dataMap.containsKey(continent)) {

                Map<String, List<String>> current = new LinkedHashMap<>();
                List<String> cityList = new ArrayList<>();
                cityList.add(city);
                current.put(country, cityList);
                dataMap.put(continent, current);

            } else if (!dataMap.get(continent).containsKey(country)) {
                List<String> cityList = new ArrayList<>();
                cityList.add(city);
                dataMap.get(continent).put(country, cityList);

            } else {
                dataMap.get(continent).get(country).add(city);

            }
        }

        for (Map.Entry<String, Map<String, List<String>>> continent : dataMap.entrySet()) {
            System.out.println(continent.getKey() + ":");

            for (Map.Entry<String, List<String>> entry : continent.getValue().entrySet()) {
                System.out.println("  " + entry.getKey() + " -> " + join(entry.getValue()));

            }
        }
    }

    private static String join(List<String> cityList) {
        return String.join(", ", cityList);
    }
}



