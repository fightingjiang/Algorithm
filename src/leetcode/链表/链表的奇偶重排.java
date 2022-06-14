package leetcode.链表;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:42 2021/7/6
 */
public class 链表的奇偶重排 {
    public ListNode oddEvenList (ListNode head) {
        if(head==null) return head;
        ListNode head1 = head.next;
        ListNode p1 = head,p2 = head1;
        while (p2!=null&&p2.next!=null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = head1;
        return head;
    }
}
