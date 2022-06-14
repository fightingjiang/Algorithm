public class hasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (low!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
     val = x;
         next = null;
     }
 }
