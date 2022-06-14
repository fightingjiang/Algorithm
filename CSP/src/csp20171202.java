import java.util.Scanner;

public class csp20171202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] child = new int[n];
        for (int i = 0; i < n ; i++) {
            child[i]=1;
        }
        int k = scanner.nextInt();
        int s = n ;
        int num = 1;
        while (s>1){
            for (int i = 0; i < n; i++) {
                if(child[i]==0){
                    continue;
                }else {
                    if (num%10==k||num%k==0){
                        child[i]=0;
                        s--;
                        if(s<=1){
                            break;
                        }
                    }
                    num++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(child[i]!=0){
                System.out.println(i+1);
                break;
            }
        }
    }
}
