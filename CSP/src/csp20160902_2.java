import java.util.Scanner;

public class csp20160902_2 {
    public static void main(String[] args) {
        int k = 1;
        int[][] location = new int[20][5];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                location[i][j] = k++;
            }
        }
        int[] remain = new int[20];
        for (int i = 0; i < 20; i++) {
            remain[i] = 5;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m =scanner.nextInt();
            int select = -1;
            int begin = -1;
            int j =0;
            for ( j = 0; j < 20; j++) {
                if(remain[j]>=m){
                    select = j;
                    begin =5-remain[j];
                    remain[j] = remain[j]-m;
                    break;
                }
            }
            if(j==20){
                int out = 0;
                while (out<m){
                    for (int l = 0; l < 20; l++) {
                        if(remain[l]>0){
                            for (int o = 5-remain[l]; o < 5; o++) {
                                    System.out.print(location[l][o]+" ");
                                    out++;
                            }
                        }
                    }
                }
                System.out.println();
            }else {
                for (j = begin; j <begin+m ; j++) {
                    System.out.print(location[select][j]+" ");
                }
                System.out.println();
            }

        }
    }
}
