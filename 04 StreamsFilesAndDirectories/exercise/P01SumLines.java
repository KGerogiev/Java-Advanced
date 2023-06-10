package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Programming\\Java Advanced\\projects\\04 StreamsFilesAndDirectories\\src\\exercise\\ziped\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line = br.readLine();

        while (line != null){
            int sum = 0;
            char[] lineArr = line.toString().toCharArray();
            for (int i = 0; i < lineArr.length; i++) {
                sum += lineArr[i];
            }
            System.out.println(sum);
            line = br.readLine();

        }
    }
}
