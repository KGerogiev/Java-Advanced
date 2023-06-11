package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> myPrices = Arrays.stream(scanner.nextLine().split(", "))
                                .map(Double::parseDouble)
                                .collect(Collectors.toList());

        Function<Double, Double> addVatFunction = price -> price * 1.2;
        print(myPrices, addVatFunction);
    }

    private static void print(List<Double> myPrices, Function<Double, Double> addVatFunction) {
        System.out.println("Prices with VAT:");
        for (Double price : myPrices){
            Double priceWithVat = addVatFunction.apply(price);
            System.out.printf("%.2f%n", priceWithVat);
        }
    }
}
