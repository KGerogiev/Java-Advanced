package lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Set<String> parking = new LinkedHashSet<>();

        while (!command.equals("END")){

            String[] currentCar = command.split(", ");

            // if the car enters the parking
            if (currentCar[0].equals("IN")){
                parking.add(currentCar[1]);
            } else {
                // if the car goes out of the parking
                parking.remove(currentCar[1]);
            }
            command = scanner.nextLine();
        }
       if (parking.isEmpty()){
           System.out.println("Parking Lot is Empty");
           return;
       }

        parking.forEach(System.out::println);

    }
}
