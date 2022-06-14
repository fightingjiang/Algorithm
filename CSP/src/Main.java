import java.util.Scanner;

public class Main {
    static int m;
    static Trash[] trashes;
    static int[] result = new int[5];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        trashes = new Trash[m];
        for (int i = 0; i < m; i++) {
            Trash trash = new Trash();
            trash.x = scanner.nextInt();
            trash.y = scanner.nextInt();
            trashes[i]= trash;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if(IsStations(trashes[i])){
                if(FindXY(trashes[i].x-1,trashes[i].y-1)){
                    count++;
                }
                if(FindXY(trashes[i].x-1,trashes[i].y+1)){
                    count++;
                }
                if(FindXY(trashes[i].x+1,trashes[i].y-1)){
                    count++;
                }
                if(FindXY(trashes[i].x+1,trashes[i].y+1)){
                    count++;
                }
                result[count]++;
                count=0;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(result[i]);

        }


    }
    static boolean FindXY(int x,int y){
       for (int i = 0; i < m; i++) {
           if(trashes[i].x==x&&trashes[i].y==y){
               return true;
           }
       }
       return false;
   }

   static boolean IsStations(Trash t){
        if(FindXY(t.x-1,t.y)&&FindXY(t.x+1,t.y)&&FindXY(t.x,t.y-1)&&FindXY(t.x,t.y+1)){
            return true;
        }
        return false;
    }

    static class Trash{
        int x;
        int y;

        public Trash() {
        }
    }
}
/*
7
1 2
2 1
0 0
1 1
1 0
2 0
0 1


11
9 10
10 10
11 10
12 10
13 10
11 9
11 8
12 9
10 9
10 11
12 11

2
0 0
-100000 10
 */