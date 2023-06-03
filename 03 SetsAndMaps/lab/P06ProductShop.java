package lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> listOfShops = new TreeMap<>();

        while (!input.equals("Revision")){
            //"{shop}, {product}, {price}"
            String[] commandArr = input.split(", ");

            //getting the information from the input
            String shop = commandArr[0];
            String product = commandArr[1];
            double price = Double.parseDouble(commandArr[2]);

            //check if the store exist
            if (!listOfShops.containsKey(shop)){
                Map<String, Double> currentMap = new LinkedHashMap<>();
                currentMap.put(product, price);
                listOfShops.put(shop, currentMap);
            } else {
                Map<String, Double> currentMap = new LinkedHashMap<>(listOfShops.get(shop));
                currentMap.put(product, price);
               listOfShops.get(shop).put(product, price);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> shop : listOfShops.entrySet()) {
            System.out.println(shop.getKey() + "->");  // магаизна
            shop.getValue().entrySet().forEach(entry -> System.out.printf("Product: %s, Price: %.1f%n",entry.getKey(), entry.getValue()));  //цената
           // shop.getValue().entrySet().forEach(entry -> System.out.println(entry.getValue()));  //цената
           }
    }
}
