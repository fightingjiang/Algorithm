package leetcode.链表;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 22:57 2021/7/5
 */
public class 链表插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
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
