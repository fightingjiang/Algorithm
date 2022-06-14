package 笔试.华为;


import java.util.Scanner;


//字符查找 方法
public class 最先只出现一次的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(s.indexOf(c)==s.lastIndexOf(c)){
                    System.out.println(c);
                    break;
                }
                if(i==s.length()-1){
                    System.out.println("-1");
                }
            }
        }

    }
}
