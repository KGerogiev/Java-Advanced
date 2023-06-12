package P01CarInfo_Lab;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= count ; i++) {
            //"{brand} {model} {horsePower}
            String input = scanner.nextLine();
            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int horsePower = Integer.parseInt(input.split("\\s+")[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carList.add(car);
        }

        for (Car car : carList) {
            System.out.println(car.getCarInfo());
        }
    }
}
