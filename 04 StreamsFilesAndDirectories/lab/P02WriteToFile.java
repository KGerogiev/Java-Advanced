package labo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pathIn = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        List<Character> characters = new ArrayList(Arrays.asList(',', '.', '!', '?'));

        try(FileInputStream inputStream = new FileInputStream(pathIn)) {
            int oneByte = inputStream.read();
            FileOutputStream outputStream = new FileOutputStream(pathOut);
            while (oneByte >= 0){

                if (!characters.contains((char) oneByte)){
                    outputStream.write(oneByte);
                }


                oneByte = inputStream.read();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
