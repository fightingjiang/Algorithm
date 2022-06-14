package 笔试.华为;


import java.util.Scanner;

public class 删除出现最少次数的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String builder = sc.nextLine();
            int[] nums = new int[26];
            for (int i = 0; i < builder.length(); i++) {
                nums[builder.charAt(i)-'a']++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0){
                    min = Math.min(min,nums[i]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==min){
                    String s = (char)(i+'a')+"";
                    builder =  builder.replace(s,"");
                }
            }
            System.out.println(builder);
        }

    }
}
