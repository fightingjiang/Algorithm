package 牛客100题;

import java.util.*;

public class 牛客100 {


    //数组和为0的三元组   左右指针解决
    //S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
    //三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
    //解集中不能包含重复的三元组。
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for (int first = 0; first < len; first++) {
            //排除重复的元素  当前元素和前一元素相等
            if(first>0&&num[first]==num[first-1]){
                continue;
            }
            int third = len-1;
            int target = -num[first];
            for (int second = first+1; second < len; second++) {
                //排除重复的元素  当前元素和前一元素相等
                if(second>first+1&&num[second]==num[second-1]) continue;
                while (second<third&&num[second]+num[third]>target){
                    third--;
                }
                if(second==third) break;
                //等于target  符合
                if(num[second]+num[third]==target){
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


    //螺旋数组
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0){
            return res;
        }
        int left = 0,right = matrix[0].length-1, up = 0,down = matrix.length-1;
        while (true){
            //右
            if(left>right){
                return res;
            }else{
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
            }
            //下
            if(up>down){
                return res;
            }else {
                for (int i = up; i <= down ; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            //左
            if(left>right){
                return res;
            }else {
                for (int i = right; i >=left ; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }
            //上
            if(up>down){
                return res;
            }else {
                for (int i = down; i >=up ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
    }


    //在旋转过的元素里找数字
    //给出一个转动过的有序数组，你事先不知道该数组转动了多少
    //(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
    //在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
    //假设数组中不存在重复项。
    public int search (int[] A, int target) {
        int low = 0,high = A.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(A[mid]==target) return mid;
            //两侧必有一侧有序
            //左侧有序
            if(A[low]<=A[mid]){
                //如果target在其中
                if(target<A[mid]&&target>=A[low]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                //右侧有序
                if(A[mid]<target&&target<=A[high]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }


    //合并区间
    //给出一组区间，请合并所有重叠的区间。
    //请保证合并后的区间按区间起点升序排列。
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() < 2){
            return intervals;
        }
        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                //start升序   end  降序
                return o1.start==o2.start?o2.end-o1.end:o1.start-o2.start;
            }
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if(res.get(res.size()-1).start==intervals.get(i).start){
                continue;
            }
            if(res.get(res.size()-1).end<intervals.get(i).start){
                res.add(intervals.get(i));
            }else {
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end,intervals.get(i).end);
            }
        }
        return res;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }


    //旋转矩阵
    public int[][] rotateMatrix(int[][] mat, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-i-1] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        return res;
    }

    //矩阵二分查找
    public boolean searchMatrix (int[][] matrix, int target) {
        int m = 0,n = matrix[0].length-1;
        while (m<matrix.length&&n>=0){
            if(target==matrix[m][n]){
                return true;
            }else if(target<matrix[m][n]){
                n--;
            }else {
                m++;
            }
        }
        return false;
    }

    //最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length||k==0) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //默认小顶堆
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if(queue.peek()>input[i]){
                queue.poll();
                queue.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new 牛客100().maxLength(new int[]{3, 1, 2, 3, 4, 3, 6, 7, 8}));
    }

    //最长无重复子串
    public int maxLength (int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = -1;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])){
                left = Math.max(left,hashMap.get(arr[i]));
            }
            hashMap.put(arr[i],i);
            if(max<i-left){
                max = i-left;
                index = left+1;
            }
        }
        int[] nums = Arrays.copyOfRange(arr, index, index + max);
        System.out.println(Arrays.toString(nums));
        return max;
    }

}
