package leetcode.公司.字节;

import java.util.Scanner;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:37 2021/7/17
 */
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        while (m-->0){
            String s = sc.nextLine();

            //自动机
            String ans = "";
            char last = s.charAt(0);
            char cur;
            int state = 0;
            ans += s.charAt(0);//初始化
            for (int i = 1; i < s.length(); i++) {
                cur = s.charAt(i);
                switch (state){
                    case 0:{
                        if(cur==last) state = 1;//如果是相等的，进入状态1，否则继续状态0；进入状态1：AA形式
                        else state = 0;//继续状态0：AB形式，即正常形式
                        break;
                    }
                    case 1:{
                        if(cur==last) continue;//AAA,忽略即可
                        else state = 2;//进入状态3：AAB形式
                        break;
                    }
                    case 2:{
                        if (cur == last) continue;//AABB，忽略即可
                        else state = 0;//AABC，就是状态0
                        break;
                    }
                    default: break;
                }
                ans = ans + cur;
                last = cur;
            }
            System.out.println(ans);
        }
    }
}
