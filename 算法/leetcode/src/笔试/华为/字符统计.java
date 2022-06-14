package 笔试.华为;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 字符统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int[][] nums = new int[36][2];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    nums[c-'0'][0] = c-'0';
                    nums[c-'0'][1]++;
                }else {
                    nums[c-'a'+10][0] = c-'a'+10;
                    nums[c-'a'+10][1]++;
                }
            }
            //先按nums[i][1]降序排
            //再按nums[i][0]升序排
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]) return o1[0]-o2[0];
                    return o2[1]-o1[1];
                }
            });
            for (int i = 0; i < nums.length; i++) {
                if(nums[i][1]!=0){
                    if(nums[i][0]<10){
                        System.out.print((char)(nums[i][0]+'0'));
                    }else {
                        System.out.print((char) (nums[i][0]+'a'-10));
                    }
                }
            }
            System.out.println();
        }

    }
}
