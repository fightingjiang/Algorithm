import java.util.HashSet;

public class 回文链表 {
      public class ListNode {
        int val;
        ListNode next = null;
      }

    public boolean isPail (ListNode head) {
        if(head==null||head.next==null) return true;
        //通过快慢指针找到链表中点
        ListNode fast = head.next,slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow 为链表的中间节点
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //将链表从中间往后倒叙
        slow = reverseList(slow);
        fast = head;
        while (slow!=null){
            if (fast.val!=slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
}
