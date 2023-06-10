package exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputNumberd.txt");

        int count = 1;

        for (String line : lines){
            writer.println(count + ". " + line);
            count++;
        }
        writer.close();
    }
}
