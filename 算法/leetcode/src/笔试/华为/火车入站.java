package 笔试.华为;


import java.util.*;

public class 火车入站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(nums);
        fun(nums);
        System.out.println();
    }

    static List<List<Integer>> res = new ArrayList<>();
    private static void fun(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> track = new LinkedList<>();
        trackback(nums,0,stack,track);
    }

    private static void trackback(int[] nums, int start, Stack<Integer> stack, LinkedList<Integer> track) {
        if(start>=nums.length) return;
        stack.push(nums[start]);
        for (int i = start; i < nums.length; i++) {
            track.add(stack.pop());
            if (stack.isEmpty()) res.add(new ArrayList<>(track));
            trackback(nums,i+1,stack,track);
        }
    }

}
