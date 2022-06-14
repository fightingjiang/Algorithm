package leetcode.双指针.链表操作;

public class Solution {
    //反转链表
    public ListNode reverse(ListNode head) {
        if(head==null) return null;
        ListNode pre = null,cur = head;
        while (cur!=null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }

    //快慢指针
    public ListNode findInNode(ListNode head){
        if(head==null) return null;
        //找到中间节点
        ListNode slow = head,fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = findInNode(head);
        ListNode secondHalfEnd = reverse(firstHalfEnd.next);

        //判断是否是回文
        ListNode node1 = head;
        ListNode node2 = secondHalfEnd;
        boolean result = true;
        while (result&&node2!=null){
            if(node1.next!=node2.next){
                result = false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        firstHalfEnd.next = findInNode(secondHalfEnd);
        return result;
    }
}
