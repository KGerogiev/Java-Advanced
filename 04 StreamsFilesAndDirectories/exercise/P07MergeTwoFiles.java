package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathOne = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        List<String> firstFile = Files.readAllLines(Path.of(pathOne));
        List<String> secondFile = Files.readAllLines(Path.of(pathTwo));
        String pathResult = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merged.txt";
        PrintWriter writer = new PrintWriter(pathResult);
        for (String line : firstFile){
            writer.println(line);
        }
        for (String line : secondFile){
            writer.println(line);
        }
        writer.close();

    }
}
