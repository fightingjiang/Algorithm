package leetcode.链表;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:52 2021/7/15
 */
public class 两个链表相加 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        ListNode p1 = revers(head1),p2 = revers(head2);
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int g = 0;
        while (p1!=null||p2!=null||g==1){
            int num1 = p1==null?0:p1.val;
            int num2 = p2==null?0:p2.val;
            int value = num1+num2+g;
            g = value/10;
            value%=10;
            tmp.next = new ListNode(value);
            tmp = tmp.next;
            p1=p1==null?null:p1.next;
            p2=p2==null?null:p2.next;
        }
        return revers(res.next);
    }

    private ListNode revers(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
