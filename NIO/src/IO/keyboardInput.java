package IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class keyboardInput {
    public static void main(String[] args) throws Exception {
       scanner();
    }

    public static void readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        System.out.println(s);
    }

    public static void readChar() throws IOException {
        char read = (char)System.in.read();
        System.out.println(read);
    }

    public static void scanner(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextInt());
            int a = scanner.nextInt();
            System.out.println(a+10);
        }
    }
}
