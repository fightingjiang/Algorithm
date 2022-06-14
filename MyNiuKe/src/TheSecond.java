
import MYListTopic.ListNode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class TheSecond {
    public static void main(String[] args) {
        ArrayList<Integer> list = GetLeastNumbers_Solution(new int[]{1, 2, 34, 5, 6, 74, 3, 7}, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    //链表反转
//    public ListNode ReverseList(MYListTopic.ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        MYListTopic.ListNode pre = null,cur = head;
//        while (cur!=null){
//            MYListTopic.ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    //链表是否有环   快慢指针  龟兔赛跑
//    public boolean hasCycle(MYListTopic.ListNode head){
//        if(head==null||head.next==null){
//            return false;
//        }
//        MYListTopic.ListNode slow = head,fast = head.next;
//        while (slow!=fast){
//            if(fast==null||fast.next==null){
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }


    //最小的k个数
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length||k==0) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
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
        for (int i = 0; i < k ; i++) {
            list.add(queue.poll());
        }
        return list;
    }


    //括号
    public boolean isValid (String s) {
        if(s.length()%2!=0) return false;
        HashMap<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')','(');
        hashmap.put(']','[');
        hashmap.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length()-1; i++) {
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

    public void merge(int A[], int m, int B[], int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = n+m-1;
        while(p1>=0&&p2>=0){
            if(A[p1]>B[p2]){
                A[p--] = A[p1--];
            }else {
                A[p--] = B[p2--];
            }
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(B,0,A,0,p2+1);
    }


    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    //树的前序中序后续
    public int[][] threeOrders (TreeNode root) {
        if(root==null) {
            return new int[][]{{}};
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        preOrder(root);
        inOrder(root);
        postOrder(root);
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }

    private void preOrder(TreeNode root) {
        if(root==null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //股票的最大盈利
    public int maxProfit (int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else {
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(0),cur = dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return dummy.next;
    }


    //大数加法
    public String solve (String s, String t) {
        StringBuilder result = new StringBuilder();
        int tmp = 0,ls = s.length()-1,lt = t.length()-1;
        while (tmp==1||ls>=0||lt>=0){
            int l = ls>=0?s.charAt(ls--)-'0':0;
            int r = lt>=0?t.charAt(lt--)-'0':0;
            int all = l+r+tmp;
            tmp = all/10;
            char ch = (char) (all%10+'0');
            result.append(ch);
        }
        return result.reverse().toString();
    }

    //最长递增子序列
    public int[] LIS (int[] arr) {
        if(arr.length<=1) return arr;
        int ans = 1;
        int count = 1;
        int index = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = 0;
            if(arr[i+1]>arr[i]){
                count++;
            }else {
                tmp = i;
                count=1;
            }
            if(count>ans){
                ans = count;
                index = tmp;
            }
        }
        int[] result = new int[ans];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[index++];
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
}
