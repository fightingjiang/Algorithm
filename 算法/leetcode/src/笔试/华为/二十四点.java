package 笔试.华为;


import java.util.Scanner;

public class 二十四点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            boolean res = fun(nums,24,0);
            System.out.println(res);
        }
    }

    private static boolean fun(int[] nums, int target, int i) {
        if(target==0) return true;
        if(i>3) return false;
        for (int j = 0; j < nums.length; j++) {
            for (int k = 0; k < nums.length; k++) {
                if(j!=k){

                }
            }
        }
        return false;
    }
}
