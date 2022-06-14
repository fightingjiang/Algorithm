package 笔试.华为;



import java.util.Scanner;

public class 字符串之和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine().trim();
            String str2 = sc.nextLine().trim();
            int up = 0;
            StringBuilder builder = new StringBuilder();
            int i = str1.length()-1;
            int j = str2.length()-1;
            while (i>=0||j>=0|| up==1){
                int x1 = i>=0?Integer.valueOf(str1.charAt(i)-'0'):0;
                int x2 = j>=0?Integer.valueOf(str2.charAt(j)-'0'):0;
                int tmp = (x1+x2+up)%10;
                builder.append(tmp);
                up = (x1+x2+up)/10;
                i--;
                j--;
            }
            System.out.println(builder.reverse().toString());
        }
    }
}
