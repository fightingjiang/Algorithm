package leetcode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:17 2021/7/21
 */
public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{7,9});
        list.add(new int[]{3,7});
        list.add(new int[]{3,5});
        list.add(new int[]{4,6});
        Collections.sort(list, (o1, o2) -> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        System.out.println();
    }
}
