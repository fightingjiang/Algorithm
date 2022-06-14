package 笔试.华为;


import java.util.Scanner;

public class 名字漂亮度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine().toUpperCase();
            int res = 0;
            for (int j = 0; j < s.length(); j++) {
                res+=s.charAt(i)-'A';
            }
            System.out.println(res);
        }

    }
}
