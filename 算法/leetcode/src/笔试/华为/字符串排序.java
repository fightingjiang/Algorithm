package 笔试.华为;


import java.util.Arrays;
import java.util.Scanner;

public class 字符串排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        Arrays.sort(strs);
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i]);
        }
    }
}
