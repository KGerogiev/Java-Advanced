package P02Constructors_Lab;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<CarConstrucots> carList = new ArrayList<>();

        for (int i = 1; i <= count ; i++) {
            //"{brand} {model} {horsePower}
            String[] inputArr = scanner.nextLine().split("\\s");

            if (inputArr.length == 1){
                String brand = inputArr[0];

                CarConstrucots car = new CarConstrucots(brand);
                carList.add(car);

            } else if (inputArr.length == 3) {
                String brand = inputArr[0];
                String model = inputArr[1];
                int horsePower = Integer.parseInt(inputArr[2]);

                CarConstrucots car = new CarConstrucots(brand, model, horsePower);
                carList.add(car);
            }

        }

        for (CarConstrucots car : carList) {
            System.out.println(car.getCarInfo());
        }
    }
}
