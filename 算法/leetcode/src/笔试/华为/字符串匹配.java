package 笔试.华为;


import java.util.Scanner;

public class 字符串匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String pattern = sc.nextLine();
            String str =  sc.nextLine();
            boolean res = match(pattern,str,0,0);
            System.out.println(res);
        }
    }

    public static boolean match(String pattern,String str,int i,int j){
        if(i>pattern.length()-1||j>str.length()-1) return false;
        if(i==str.length()-1&&j==str.length()-1)  return true;
        if(pattern.charAt(i)==str.charAt(j)||pattern.charAt(i)=='?'){
            return match(pattern,str,i+1,j+1);
        }else if ( pattern.charAt(i)=='*'){
            // 0个，1个，多个
           return match(pattern,str,i+1,j)||match(pattern,str,i+1,j+1)||match(pattern,str,i,j+1);
        }else {
            return false;
        }
    }
}
