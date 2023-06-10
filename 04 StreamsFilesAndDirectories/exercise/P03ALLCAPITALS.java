package exercise;

import java.io.*;

public class P03ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt"));

        String line = reader.readLine();

        while (line != null){
            String modifiedLine = line.toUpperCase();
            writer.write(modifiedLine);
            writer.newLine();
            line = reader.readLine();
        }
        writer.close();
    }
}
