public class 链表中的第k个节点 {

    public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead==null) return null;
        ListNode slow = pHead,fast = pHead;
        for (int i = 0; i < k; i++) {
            if(fast==null) return null;
            fast = fast.next;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
