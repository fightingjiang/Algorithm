import java.util.Scanner;

public class csp20200902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t =scanner.nextInt();
        int xl = scanner.nextInt();
        int yl = scanner.nextInt();
        int xr = scanner.nextInt();
        int yh = scanner.nextInt();
        int p = 0;
        int w = 0;
        for (int i = 0; i < n; i++) {
            int pass = 0;
            int wait = 0;
            int max = 0;
            for (int j = 0; j < t; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if(x>=xl&&x<=xr&&y<=yh&&y>=yl){
                    pass++;
                    wait++;
                }else {
                    wait = 0;
                }
                max = Math.max(max,wait);
            }
            if(pass>=1){
                p++;
            }
            if(max>=k){
                w++;
            }

        }
        System.out.println(p);
        System.out.println(w);
    }
}
