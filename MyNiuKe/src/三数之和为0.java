import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和为0 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if(first>0&&num[first-1]==num[first]){
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -num[first];
            //枚举b
            for (int second = first+1; second < n; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && num[second] == num[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && num[second] + num[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (num[second] + num[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[first]);
                    list.add(num[second]);
                    list.add(num[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
