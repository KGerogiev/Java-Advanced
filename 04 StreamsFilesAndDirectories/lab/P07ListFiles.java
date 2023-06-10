package labo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        if (file.isDirectory()){
            File[] folder = file.listFiles();
            for (File item : folder) {
                if (!item.isDirectory()){
                    System.out.printf("%s: [%d]%n", item.getName(), item.length());
                }
            }
        }
    }
}
