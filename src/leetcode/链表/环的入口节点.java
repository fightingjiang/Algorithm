package leetcode.链表;

import java.util.HashSet;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:47 2021/7/6
 */
public class 环的入口节点 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode pos = head;
        while (pos!=null){
            if(set.contains(pos)){
                return pos;
            }else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        ListNode ptr = head;
        while (ptr!=slow){
            ptr = ptr.next;
            slow =slow.next;
        }
        return slow;
    }
}
