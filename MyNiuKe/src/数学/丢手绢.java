package 数学;

import java.util.Arrays;

public class 丢手绢 {
    public static void main(String[] args) {
        System.out.println(new 丢手绢().LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        int[] nums = new int[n];
        int nn = n;
        Arrays.fill(nums,1);
        if(n==0||n==1) return -1;
        int shu = 0;//报数
        int index = 0;//下标
        while(n>1){
            if(nums[index]==0){
                index = (index+1)%nn;
            }else {
                if(shu==m-1){
                    nums[index] = 0;
                    n--;
                    shu = 0;
                    index = (index+1)%nn;
                }else {
                    shu++;
                    index = (index+1)%nn;
                }
            }
        }
        for (int i = 0; i < nn; i++) {
            if(nums[i]==1) return i;
        }
        return -1;
    }
}
