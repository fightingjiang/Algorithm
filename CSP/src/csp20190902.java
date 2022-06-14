import java.util.ArrayList;
import java.util.Scanner;

public class csp20190902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> error = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int M = scanner.nextInt();
            int[] data = new int[M];
            for (int j = 0; j < M; j++) {
                data[j] = scanner.nextInt();
            }
            long del = 0;
            int before = data[0];
            int now = before;
            for (int j = 1; j < M; j++) {
                if(data[j]<=0){
                    del+=data[j];
                    now+=data[j];
                }else if(data[j]>0){
                   now = data[j];
                }
            }
            sum+=now;
            if((before+del)!=now){
                error.add(i);
            }
        }
        int D = error.size();
        int T = 0;
        if(D>=3){
            int[] result = new int[D+2];
            result[0] = error.get(D-2)-N;
            result[1] = error.get(D-1)-N;
            for (int i = 0; i < D; i++) {
                result[i+2] = error.get(i);
            }
            for (int i = 1; i < result.length-1; i++) {
                if(result[i-1]+1==result[i]&&result[i]==result[i+1]-1){
                    T++;
                }
            }
        }
        System.out.println(sum+" "+D+" "+T);
    }
}
/*
4
4 74 -7 -12 -5
5 73 -8 -6 59 -4
5 76 -5 -10 60 -2
5 80 -6 -15 59 0

5
4 10 0 9 0
4 10 -2 7 0
2 10 0
4 10 -3 5 0
4 10 -1 8 0

 */