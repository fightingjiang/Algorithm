package leetcode.公司;

import java.util.Scanner;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 19:58 2021/7/8
 */
public class 字符串中找出连续最长的数字串 {
    public static String fun(String str){
        int index = 0;
        int len = 0;
        int left = -1,right;
        for( right =  0;right<str.length();right++){
            if(!Character.isDigit(str.charAt(right))){
                //不是数字
                if(right-left-1>len){
                    index = right;
                    len = right-left-1;
                }
                left = right;
            }
        }
        if(Character.isDigit(str.charAt(str.length()-1))){
            if(right-left-1>len){
                index = right;
                len = right-left-1;
            }
        }
        return str.substring(index-len,index);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(fun(str));
    }
}
