import java.util.Scanner;

public class csp20200901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] result = new int[3][2];
        for (int i = 0; i < 3; i++) {
            result[i][0] = Integer.MAX_VALUE;
        }
        int n = scanner.nextInt();
        Node person = new Node();
        person.x = scanner.nextInt();
        person.y = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            Node point = new Node();
            point.x = scanner.nextInt();
            point.y = scanner.nextInt();
            for (int j = 0; j < 3; j++) {
                if(distance(person,point)<result[j][0]){
                    int temp1 = result[j][0];
                    int p1 = result[j][1];
                    result[j][0] = distance(person,point);
                    result[j][1] = i;
                    for (int k = j+1; k < 3; k++) {
                        int temp2 = result[k][0];
                        int p2 = result[k][1];
                        result[k][0] = temp1;
                        result[k][1] = p1;
                        temp1 = temp2;
                        p1 = p2;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i][1]);
        }


    }
    public static int distance(Node a, Node b){
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }
    static class Node {
        int x,y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
