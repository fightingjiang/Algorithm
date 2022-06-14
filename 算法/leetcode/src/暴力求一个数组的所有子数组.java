import java.util.ArrayList;

public class 暴力求一个数组的所有子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                list.add(nums[j]);
                System.out.println(list.toString());
            }
        }
    }
}
