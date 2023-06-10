package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));

        long sumBytes = 0;

        String line = br.readLine();

        while (line != null){

            char[] lineArr = line.toString().toCharArray();
            for (int i = 0; i < lineArr.length; i++) {

                sumBytes += lineArr[i];
            }
            line = br.readLine();

        }
        System.out.println(sumBytes);
    }
}
