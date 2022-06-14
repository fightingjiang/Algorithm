package leetcode.链表;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:49 2021/7/6
 */
public class 删除链表中的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null )return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next!=null&&pre.next.next!=null){
            if(pre.next.val!=pre.next.next.val){
                pre = pre.next;
            }else {
                ListNode tmp = pre.next;
                while (tmp.next!=null&&tmp.val==tmp.next.val){
                    tmp = tmp.next;
                }
                pre.next = tmp.next;
            }
        }
        return dummy.next;
    }
}
