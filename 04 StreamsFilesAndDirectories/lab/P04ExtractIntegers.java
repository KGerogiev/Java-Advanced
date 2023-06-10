package labo;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String pathIn = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathIn);
        Scanner reader = new Scanner(inputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
        PrintWriter writer = new PrintWriter(fileOutputStream);


        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }
            reader.next();
        }
        writer.close();


    }
}
