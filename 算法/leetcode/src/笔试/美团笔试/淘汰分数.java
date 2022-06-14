package 笔试.美团笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 淘汰分数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = -1;
        for (int i = x-1; i < n; i++) {
            //淘汰人数在x-y之间
            if(i>=y) break;
            if(i<y&&n-1-i<=y&&n-1-i>=x){
                res = nums[i];
                break;
            }
        }
        System.out.println(res);
    }
}
