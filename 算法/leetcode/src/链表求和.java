
public class 链表求和 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode helper = res;
        int tmp = 0;
        int up = 0;
        while (l1!=null&&l2!=null){
            int sum = l1.val+l2.val+up;
            if(sum>9){
                tmp = sum-10;
                up++;
            }else {
                tmp = sum;
                up = 0;
            }
            helper.next = new ListNode(tmp);
            helper = helper.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return res.next;
    }
}
