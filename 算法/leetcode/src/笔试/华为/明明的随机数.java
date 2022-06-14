package 笔试.华为;

import java.util.Scanner;

public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[1001];
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                nums[m]++;
            }
            for (int i = 0; i < 1001; i++) {
                if(nums[i]!=0){
                    System.out.println(i);
                }
            }
        }
    }
}
