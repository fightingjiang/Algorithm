package 笔试.华为;


import java.util.Scanner;

public class 坐标移动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] split = s.split(";");
            int x = 0;
            int y = 0;
            for (String str:split) {
                //是否有效
                if (!judge(str)) continue;
                char c = str.charAt(0);
                Integer integer = Integer.valueOf(str.substring(1, str.length() ));
                switch (c){
                    case 'A':x = x-integer;break;
                    case 'D':x = x+integer;break;
                    case 'W':y = y+integer;break;
                    case 'S':y = y-integer;break;
                }
            }
            System.out.println(x+","+y);
        }
    }

    private static boolean judge(String str) {
        if(str==null||str.length()==0||str.length()==1||str.length()>3) return false;
        char c = str.charAt(0);
        if(c=='A'||c=='D'||c=='W'||c=='S'){
            for (int i = 1; i < str.length(); i++) {
                if(!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
