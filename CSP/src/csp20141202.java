import java.util.Scanner;

public class csp20141202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=scanner.nextInt();
            }
        }
        int m = 2*(n-1);
        for (int i = 0; i <= m; i++) {
            if(i<=(n-1)){
                if(i%2==0){
                    for (int j = i; j >=0 ; j--) {
                        System.out.print(matrix[j][i-j]+" ");
                    }
                }else {
                    for (int j = 0; j <=i ; j++) {
                        System.out.print(matrix[j][i-j]+" ");
                    }
                }
            }else {
                if(i%2==0){
                    for (int j = n-1; j >=i-(n-1) ; j--) {
                        System.out.print(matrix[j][i-j]+" ");
                    }
                }else {
                    for (int j = i-(n-1); j <=(n-1) ; j++) {
                        System.out.print(matrix[j][i-j]+" ");
                    }
                }
            }
        }


    }
}
