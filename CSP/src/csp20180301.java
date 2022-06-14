import java.util.Scanner;

public class csp20180301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int d = 0;
        String line = scanner.nextLine();
        for (int i = 0; i < line.length()-1; i=i+2) {
            int x  = (int)(line.charAt(i)-'0');
            if(x==1){
                sum+=1;
                d=0;
            }else {
                d++;
                sum+=d*2;
            }
        }
        System.out.println(sum);
    }
}
