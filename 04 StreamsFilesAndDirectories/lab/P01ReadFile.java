package labo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try ( FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));

                oneByte = fileStream.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}
