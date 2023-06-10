package labo;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {

    public static void main(String[] args) {

        File root = new File("F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Serialization\\Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;
        //Breadth-First Search (BFS)
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders\n", count);
    }
}