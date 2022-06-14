package Easy;

import MYListTopic.ListNode;

import java.util.*;

public class MyEasy {
    //寻找第k大的数
    public int findKth01(int[] a, int n, int K) {
        return find(a,0,n-1,K);
    }

    private int find(int[] a, int low, int high, int K) {
        //partition函数分区   即找基准元素
        int partition = partition(a,low,high);
        if (partition+1>K){
            return find(a,low,partition-1,K);
        }else if(partition+1<K){
            return find(a,partition+1,high,K);
        }else {
            return a[partition];
        }
    }

    //和快速排序的分区函数一样
    private int partition(int[] a, int i, int j) {
        int pivot = i;
        int left = i,right = j;
        while (true){
            //基础元素左边大 右边小
            //从右往左找一个大的
            while (left<right&&a[right]<=a[pivot]){
                right--;
            }
            while (left<right&&a[left]>=a[pivot]){
                left++;
            }
            if(left<right){
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }else {
                break;
            }
        }
        //把基准元素与left位置元素交换
        int tmp = a[pivot];
        a[pivot] = a[left];
        a[left] = tmp;
        return left;
    }

    //最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution01(int [] input, int k) {
        if(k>input.length||k==0) return new ArrayList<>();

        //构建最大堆  优先队列  遇到小的把堆顶元素换出  默认是小顶
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }


    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow = head,fast = head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //反转链表
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = null,cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //两数之和
    static public int[] twoSum (int[] numbers, int target) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            if(hashMap.containsKey(target-numbers[i])){
//                return new int[]{hashMap.get(target-numbers[i]),i};
//            }
//            hashMap.put(numbers[i],i);
//        }
//        return  new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(hashMap.containsKey(target-numbers[i])){
                return new int[]{hashMap.get(target-numbers[i]),i};
            }else {
                hashMap.put(numbers[i],i);
            }
        }
        return new int[0];
    }

    //连续子序列最大和
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int nowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            if(nowSum+nums[i]>0){
                nowSum = nowSum+nums[i];
                max = Math.max(max,nowSum);
            }else {
                nowSum = 0;
            }
        }
        return max;
    }

    //连续子序列最大和   官方解
    public int maxSubArray01(int[] nums) {
//        int max = nums[0];
//        int pre = 0;
//        for (int i = 0; i < nums.length; i++) {
//            pre = Math.max(nums[i],pre+nums[i]);
//            max = Math.max(max,pre);
//        }
//        return max;
        int pre = 0,max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }


    //合并两个有序数组
    public void merge(int nums1[], int m, int nums2[], int n) {
//        int p1 = m-1,p2 = n-1, p = m+n-1;
//        while (p1>=0&&p2>=0){
//            if(nums1[p1]>nums2[p2]){
//                nums1[p] = nums1[p1];
//                p1--;
//                p--;
//            }else {
//                nums1[p] = nums2[p2];
//                p2--;
//                p--;
//            }
//        }
//        while (p1>=0){
//            nums1[p--] = nums1[p1--];
//        }
//        while (p2>=0){
//            nums1[p--] = nums2[p2--];
//        }
        int p1 = m-1,p2 = n-1,p = m+n-1;
        while (p1>=0&&p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[p--] = nums1[p1--];
            }else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p1>=0){
            nums1[p--] = nums1[p1--];
        }
        while (p2>=0){
            nums1[p--] = nums2[p2--];
        }
    }

    //括号
    public boolean isValid (String s) {
//        if(s.length()/2==0){
//            return false;
//        }
//        HashMap<Character, Character> hashmap = new HashMap<>();
//        hashmap.put(')','(');
//        hashmap.put(']','[');
//        hashmap.put('}','{');
//
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if(hashmap.containsKey(ch)){
//                if (stack.isEmpty()||stack.peek()!=hashmap.get(ch)){
//                    return false;
//                }
//                stack.pop();
//            }else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
        if(s.length()%2==1){
            return false;
        }
        HashMap<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')','(');
        hashmap.put(']','[');
        hashmap.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hashmap.containsKey(ch)){
                if(stack.isEmpty()||stack.peek()!=hashmap.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    //top-k   最小的k个
    static public int[] getLeastNumbers(int[] arr, int k) {
//        int[] result = new int[k];
//        if(k==0) return result;
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            queue.offer(arr[i]);
//        }
//        for (int i = k; i < arr.length; i++) {
//            if(arr[i]<queue.peek()){
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            result[i] = queue.poll();
//        }
//        return result;
        //最大堆解决
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }


    //第k大的数
    public static int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < K; i++) {
            queue.offer(a[i]);
        }
        for (int i = K; i < a.length; i++) {
            if(a[i]>queue.peek()){
                queue.poll();
                queue.offer(a[i]);
            }
        }
        return queue.peek();
    }


    //两个栈实现一个队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //插入操作
    public void push(int node) {
        stack1.push(node);
    }
    //删除操作
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    //求平方根
    public int mySqrt(int x) {
        int left = 0,right = x,ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if((long) mid*mid<=x){
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while (l<=r){
            int mid = l+ (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return -1;
    }

    //买股票
    public int maxProfit(int prices[]) {
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<=min){
                min = prices[i];
            }else {
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }

    public static int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        for(int i =2;i<=n;i++){
            f3 = f1+f2;
            f1= f2;
            f2 = f3;
        }
        return f3;
    }

    public static int Fibonacci01(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //超过一半的数字
    public int majorityElement(int[] nums) {
        int x = 0,votes = 0;
        for (int num:nums
             ) {
            if(votes==0) x = num;
            votes+=(x==num)?1:-1;

        }
        return x;
    }


    //最小的K个
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length||k==0) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
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

    //二叉树的层序遍历
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list1 = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                list1.add(queue.poll().val);
            }
            list.add(list1);
        }
        return list;
    }

    static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}
