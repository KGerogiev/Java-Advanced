package labo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inPath = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        FileInputStream inputStream = new FileInputStream(inPath);
        Scanner reader = new Scanner(inputStream);

        FileOutputStream outputStream = new FileOutputStream("F:\\\\Programming\\\\Java Advanced\\\\projects\\\\04 StreamsFilesAndDirectories\\\\src\\\\lab\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\\\05.WriteEveryThirdLineOutput.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int counter = 1;

        while (reader.hasNext()){
            String currentLine = reader.nextLine();
            if (counter % 3 == 0){
                writer.println(currentLine);
            }
            counter++;

        }
        writer.close();





    }
}
