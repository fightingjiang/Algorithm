package leetcode.链表;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:13 2021/7/6
 */
public class k个一组翻转 {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode(0, head);
        ListNode pre = head;
        int len = 0;
        while (pre!=null){
            len++;
            pre = pre.next;
        }
        int n = len/k;
        pre = dummy;
        ListNode cur = head;
        int m = k;
        while (n-->0){
            while (m-->1){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
            m = k;
        }
        return dummy.next;
    }
}
