package 笔试.华为;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 迷宫问题 {

    static class Node{
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+this.x+","+this.y+")";
        }
    }

    static LinkedList<LinkedList<Node>> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            res = new LinkedList<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] nums = new int[n][m];
            int[][] flags = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            LinkedList<Node> track = new LinkedList<>();
            trackback(0,0,track,flags,nums);
            for (int i = 0; i < res.size(); i++) {
                LinkedList<Node> nodes = res.get(i);
                for (int j = 0; j < nodes.size(); j++) {
                    System.out.println(nodes.get(j).toString());
                }
            }
        }
    }

    private static void trackback(int startx, int starty, LinkedList<Node> track, int[][] flags, int[][] nums) {
        if(startx<0||startx>nums.length-1||starty<0||starty>nums[0].length-1||flags[startx][starty]==1||nums[startx][starty]==1) return;
        flags[startx][starty] =1;
        track.add(new Node(startx,starty));
        if(startx==nums.length-1&&starty==nums[0].length-1) {
            res.add(new LinkedList<>(track));
            return;
        }
        trackback(startx-1,starty,track,flags,nums);
        trackback(startx+1,starty,track,flags,nums);
        trackback(startx,starty-1,track,flags,nums);
        trackback(startx,starty+1,track,flags,nums);
        track.removeLast();
    }
}
