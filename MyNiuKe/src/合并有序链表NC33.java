public class 合并有序链表NC33 {
      public class ListNode {
        int val;
        ListNode next = null;
          public ListNode(int val) {
              this.val = val;
          }
      }
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = null;
        if(l1.val<l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }

    public ListNode mergeTwoLists01 (ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p = new ListNode(0);
        ListNode head = p;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1!=null) head.next = l1;
        if(l2!=null) head.next = l2;
        return p.next;
    }
}
