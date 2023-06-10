package exercise;

import java.io.File;
import java.nio.file.Files;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;

        for (File file : allFiles){
            folderSize += file.length();
        }
        System.out.println(folderSize);
    }
}
