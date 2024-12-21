package stream;

import java.io.*;
import java.util.Arrays;

public class FileV1 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("abc.dat");
        FileReader fr = new FileReader("abc.dat");
        BufferedReader br = new BufferedReader(fr);

        fw.write("abcdef");
        fw.close();

        System.out.println(br.readLine());
    }
}
