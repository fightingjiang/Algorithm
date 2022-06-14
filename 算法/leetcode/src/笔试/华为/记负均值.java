package 笔试.华为;


import java.util.Scanner;

public class 记负均值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zh = 0,fu = 0;
        double sum = 0;
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if(s==null||s.length()==0) break;
            int n = Integer.parseInt(s);
            if(n<0){
                fu++;
            }else {
                zh++;
                sum+=n;
            }
        }
        double res = sum/zh*1.0;
        System.out.println(fu);
        if(zh==0){
            System.out.println("0.0");
        }else {
            System.out.printf("%.1f",res);
        }

    }
}
