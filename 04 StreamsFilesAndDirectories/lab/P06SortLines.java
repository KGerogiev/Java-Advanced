package labo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));
        Collections.sort(lines);

        PrintWriter pr = new PrintWriter("F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");
        for (String line : lines) {
            pr.println(line);
        }
        pr.close();

    }
}
