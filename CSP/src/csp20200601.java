import java.util.ArrayList;
import java.util.Scanner;

public class csp20200601 {
    public static void main(String[] args) {
        ArrayList<Node> anodes = new ArrayList<>();
        ArrayList<Node> bnodes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.x = scanner.nextInt();
            node.y = scanner.nextInt();
            String type = scanner.next();
            if("A".equals(type)){
                anodes.add(node);
            }else {
                bnodes.add(node);
            }
        }

        for (int i = 0; i < m; i++) {
            int theta1 = scanner.nextInt(),theta2 = scanner.nextInt(),theta3 = scanner.nextInt();
            String result = "Yes";
            boolean flag = fun(theta1,theta2,theta3,anodes.get(0));
            for (Node node:anodes
                 ) {
                if(fun(theta1,theta2,theta3,node)!=flag){
                    result = "No";
                    break;
                }
            }
            for (Node node:bnodes
            ) {
                if(fun(theta1,theta2,theta3,node)==flag){
                    result = "No";
                    break;
                }
            }
            System.out.println(result);
        }


    }
    static Boolean fun(int theta1,int theta2,int theta3,Node node){
        if(theta1+theta2*node.x+theta3*node.y>0){
            return true;
        }else {
            return false;
        }
    }

    static class Node{
        int x;
        int y;

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}


/*
9 3
1 1 A
1 0 A
1 -1 A
2 2 B
2 3 B
0 1 A
3 1 B
1 3 B
2 0 A
0 2 -3
-3 0 2
-3 1 1
 */