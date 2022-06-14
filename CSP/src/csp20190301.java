import java.util.Scanner;

public class csp20190301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int first = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[n - 1]);
        int max ;
        int min ;
        double mid;
        if(first>=end){
            max = first;
            min = end;
        }else {
            max = end;
            min = first;
        }
        System.out.print(max+" ");
        if(n%2==0){
            int x1 = Integer.parseInt(split[(n/2)-1]);
            int x2 = Integer.parseInt(split[n/2]);
            if((x1+x2)%2==0){
                mid = (x1+x2)/2;
                System.out.print((int)mid);
            }else {
                mid = (x1+x2)/2.0;
                System.out.printf("%.1f",mid);
            }
        }else {
            mid = Integer.parseInt(split[n/2]);
            System.out.print((int)mid);
        }
        System.out.print(" "+min);
    }
}
/*
4
-2 -1 3 4
 */