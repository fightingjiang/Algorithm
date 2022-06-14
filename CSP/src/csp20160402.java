import java.util.Scanner;

public class csp20160402 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[15][10];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[] ban = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(scanner.nextInt()==1){
                    ban[j]++;
                }
            }
        }
        int bl = 0;
        for (int i = 0; i < 4; i++) {
            if(ban[i]!=0){
                bl = i;
                break;
            }
        }
        int l = scanner.nextInt();
        for (int j = l; j < l+4; j++) {
            for (int i = 4; i < 15; i++) {
                if(matrix[i][j]==1){
                    for (int k = 0; k < ban[bl]; k++) {
                        matrix[i--][l] =1;
                    }
                    break;
                }
            }

        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
}
