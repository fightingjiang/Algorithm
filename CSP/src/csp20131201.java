import java.util.Scanner;

public class csp20131201 {
    public static void main(String[] args) {
        int[] hash = new int[10000 + 1];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            hash[data]++;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < 10001; i++) {
            if(hash[i]>max){
                max = hash[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
