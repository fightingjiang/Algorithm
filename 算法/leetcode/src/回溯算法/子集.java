package 回溯算法;

import java.util.ArrayList;

public class 子集 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subset = new 子集().subset(new int[]{1, 2, 3});
        for (ArrayList<Integer> list: subset
             ) {
            System.out.println(list.toString());
        }
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subset(int[] nums){
        trackback(nums,0);
        return res;
    }

    private void trackback(int[] nums, int start) {
        if(start>nums.length) return;
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            trackback(nums,i+1);
            track.remove(track.size()-1);
        }
    }
}
