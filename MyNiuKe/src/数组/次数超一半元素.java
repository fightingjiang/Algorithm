package 数组;

public class 次数超一半元素 {
    public int MoreThanHalfNum_Solution(int [] array) {
        //[1,2,3,2,2,2,5,4,2]
        int res = 0;
        int[] nums = new int[10];
        for (int i = 0; i < array.length; i++) {
            nums[array[i]]++;
            if(nums[array[i]]>array.length/2){
                res = array[i];
                break;
            }
        }
        return res;
    }
}
