package labo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathIn = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream input = new FileInputStream(pathIn);
        FileOutputStream output = new FileOutputStream(pathOut);

        int oneByte = input.read();

        while (oneByte >= 0){

            String digits = String.valueOf(oneByte);

            if (digits.equals("32") || digits.equals("10")){
                output.write((char) oneByte);
            } else {

                for (int i = 0; i < digits.length(); i++) {
                    output.write(digits.charAt(i));
                }
            }


            oneByte = input.read();
        }


    }
}
