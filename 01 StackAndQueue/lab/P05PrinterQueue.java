package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printQueue = new ArrayDeque<>();

        while (!input.equals("print")){

            if (input.equals("cancel")){
                // cancel
                if (printQueue.size() >= 1){
                    String lastDoc = printQueue.poll();
                    System.out.printf("Canceled %s%n", lastDoc);
                } else {
                    System.out.println("Printer is on standby");
                }

            } else {
                // document
                printQueue.offer(input);
            }
            input = scanner.nextLine();
        }


        for (String token : printQueue) {
            System.out.println(token);
        }
    }
}
