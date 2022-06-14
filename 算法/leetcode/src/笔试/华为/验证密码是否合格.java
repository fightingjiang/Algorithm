package 笔试.华为;


import java.util.Scanner;

public class 验证密码是否合格 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNextLine()){
            str = sc.nextLine();
            //021Abc9Abc1
            System.out.println(fun(str));
        }

    }

    private static String fun(String str) {
        if(str.length()<=8) return "NG";
        int[] nums = new int[4];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)){
                nums[0]++;
            }else if(Character.isUpperCase(c)){
                nums[1]++;
            }else if(Character.isLowerCase(c)){
                nums[2]++;
            }else {
                nums[3]++;
            }
        }
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i]!=0) d++;
        }
        if(d<3) return "NG";
        while (true){
            for (int i = 3; i < str.length(); i++) {
                int res = 0;
                int k = 0;
                for (int j = i; j < str.length(); j++) {
                    if(str.charAt(k++)==str.charAt(j)){
                        res++;
                        if(res>2) return "NG";
                    }else {
                        res = 0;
                    }
                }
            }
            return "OK";
        }
    }
}
