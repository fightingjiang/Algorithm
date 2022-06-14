package leetcode.排序.mid;

import leetcode.链表.ListNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:53 2021/7/9
 */
public class 链表排序 {
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode lastSorted = head,cur = head.next;
        while (cur!=null){
            if(lastSorted.val<=cur.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummy;
                while (pre.next.val<cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
