import java.util.Scanner;

public class csp20170302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] location = new int[n];
        for (int i = 0; i < n; i++) {
            location[i] = i+1;
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int now = scanner.nextInt();
            int q = scanner.nextInt();
            int index = -1;
            for (int j = 0; j < n; j++) {
                if(now==location[j]){
                    index = j;
                    break;
                }
            }
            if(q>=0){
                int temp = location[index];
                for (int j = index; j < index+q; j++) {
                    location[j] = location[j+1];
                }
                location[index+q] = temp;
            }else {
                int temp = location[index];
                for (int j = index; j > index+q; j--) {
                    location[j] = location[j-1];
                }
                location[index+q] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(location[i]+" ");

        }

    }
}
