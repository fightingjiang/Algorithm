package MYListTopic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class TopicList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        ListNode node = mergeTwoLists(node1, n1);
        while (node!=null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    //链表中环的入口点
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode meetingNode = meetingNode(head);
        if(meetingNode==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = meetingNode;
        while (fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }
    //判断是否有环
    public static boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow = head,fast = head.next;
//        while (slow!=fast){
//            if (fast==null||fast.next==null){
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
        while (fast!=null&&fast.next!=null){
            if(slow==fast){
                return  true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //反转链表
    public static ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = null,cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //反转链表   递归方法
    public static ListNode ReverseList01(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = ReverseList01(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    //合并两个有序链表
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1!=null&&l2!=null){
            if(l1.value<l2.value){
                tmp.next = l1;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1!=null){
            tmp.next = l1;
        }
        if(l2!=null){
            tmp.next = l2;
        }
        return head.next;
    }

    //合并两个有序链表
    public static ListNode mergeTwoLists01 (ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = null;
        if(l1.value<l2.value){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l2.next,l1);
        }
        return head;
    }

    //倒数第k个解
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head,fast = head;
        while (fast!=null){
            fast = fast.next;
            if (k--<=0){
                slow = slow.next;
            }
        }
        return slow;
    }

    //k个一反转  栈实现
    public static ListNode reverseKGroup (ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (true){
            int count = 0;
            ListNode tmp = head;
            while (tmp!=null&&count<k){
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            if(count!=k){
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pop();
                p = p.next;
            }

        }
        return null;
    }

    //两个链表的第一个重合节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode A = headA,B = headB;
        while (A!=B){
            A = A!=null?A.next:headB;
            B = B!=null?B.next:headA;
        }
        return A;
    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.value);
            head = head.next;
        }
        int left = 0;
        int right =list.size()-1;
        while (left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //移除重复节点
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pos = head;
        set.add(head.value);
        while (pos.next!=null){
            ListNode node = pos.next;
            if(set.add(node.value)){
                pos = pos.next;
            }else {
                pos.next = pos.next.next;
            }
        }
        pos.next=null;
        return head;
    }

    //链表的中间节点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //重排链表
    public void reorderList(ListNode head) {
        if(head==null) return;
        ArrayList<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        int left = 0,right = list.size()-1;
        while (left<right){
            list.get(left).next = list.get(right);
            left++;
            if(left==right){
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next=null;
    }

}
