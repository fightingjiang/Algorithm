import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class csp20200903 {
    private static String[] strings;
    private static int[][] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();//Q个问题
        while (Q>0){
            int M = scanner.nextInt();//电路总输入
            int N = scanner.nextInt();//器件个数
            strings = new String[N];
            scanner.nextLine();
            for (int i = 0; i < N; i++) {
                strings[i] = scanner.nextLine();
            }
            int S = scanner.nextInt();//电路运行几次
            input = new int[S][M];//输入
            for (int i = 0; i < S; i++) {
                for (int j = 0; j < M; j++) {
                    input[i][j] = scanner.nextInt();
                }
            }
            HashMap<Integer, ArrayList<Integer>> outList = new HashMap<>();
            for (int i = 0; i < S; i++) {
                int key = scanner.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(key);
                for (int j = 0; j < key; j++) {
                    list.add(scanner.nextInt());
                }
                outList.put(i,list);
            }
            for (int i = 0; i < S; i++) {
                ArrayList<Integer> result = new ArrayList<>();
                ArrayList<Integer> list = outList.get(i);
                for (int j = 1; j < list.size(); j++) {
                    int solution = solution(i, strings[list.get(j) - 1]);
                    result.add(solution);
                }

                for (int j = 0; j < result.size(); j++) {
                    System.out.print(result.get(j)+" ");
                }
                System.out.println();
            }
            Q--;
        }
    }

//    string =  AND 2 I1 O3
    private static int solution(int s,String string) {
        String[] split = string.split(" ");
        int parseInt = Integer.parseInt(split[1]);
        int[] in = new int[parseInt];
        for (int i = 0; i < parseInt; i++) {
            if(split[i+2].contains("O")){
                in[i] = solution(s,strings[split[i+2].charAt(1)-'0'-1]);
            }else {
                in[i] =  input[s][split[i+2].charAt(1)-'0'-1];
            }
        }
        String str = split[0];
        if("NOT".equals(str)){
            return NOT(in);
        }else if("AND".equals(str)){
            return AND(in);
        }else if("OR".equals(str)){
            return OR(in);
        }else if("XOR".equals(str)){
            return XOR(in);
        }else if("NAND".equals(str)){
            return NAND(in);
        }else {
            return NOR(in);
        }
    }


    static int NOT(int... val){
        if(val[0]==1){
            return 0;
        }else {
            return 1;
        }
    }

    static int AND(int...val){
        for (int i = 0; i < val.length; i++) {
            if(val[i]==0){
                return 0;
            }
        }
        return 1;
    }

    static int OR(int...val){
        for (int i = 0; i < val.length; i++) {
            if(val[i]==1){
                return 1;
            }
        }
        return 0;
    }
    static int XOR(int...val){
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < val.length; i++) {
            if(val[i]==1){
                flag1=true;
            }
            if(val[i]==0){
                flag2 = true;
            }
        }
        if(flag1==true&&flag2==true){
            return 1;
        }else {
            return 0;
        }
    }
    static int NAND(int...val){
        if(AND(val)==1){
            return 0;
        }else {
            return 1;
        }
    }

    static int NOR(int...val){
        if(OR(val)==1){
            return 0;
        }else {
            return 1;
        }
    }
}

/*
2
3 5
XOR 2 I1 I2
XOR 2 O1 I3
AND 2 O1 I3
AND 2 I1 I2
OR 2 O3 O4
4
0 1 1
1 0 1
1 1 1
0 0 0
2 5 2
2 5 2
2 5 2
2 5 2




 */