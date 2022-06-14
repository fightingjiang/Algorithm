public class removeNthFromEndNC53 {

    public class ListNode {
    int val;
    ListNode next = null;
  }
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode slow = head,fast = head;
        while (n-->0){
            fast = fast.next;
        }
        if(slow==null){
            return head.next;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
