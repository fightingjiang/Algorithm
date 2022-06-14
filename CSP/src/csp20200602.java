import java.util.Scanner;

public class csp20200602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] u = new int[a][2];
        int[][] v = new int[b][2];
        for (int i = 0; i < a; i++) {
            u[i][0] = scanner.nextInt();
            u[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < b; i++) {
            v[i][0] = scanner.nextInt();
            v[i][1] = scanner.nextInt();
        }
        long sum = 0;
        int i=0,j=0;
        while (i<a&&j<b){
            if(u[i][0]==v[j][0]){
                sum +=u[i][1]*v[j][1];
                i++;
                j++;
            }else if(u[i][0]>v[j][0]){
                j++;
            }else {
                i++;
            }
        }
        System.out.println(sum);
    }
}
/*
10 3 4
4 5
7 -3
10 1
1 10
4 20
5 30
7 40

 */