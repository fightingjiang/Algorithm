package leetcode.链表;

import java.util.Stack;

public class List {
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int g = 0;
        while (l1!=null||l2!=null||g!=0){
            int l1Value = l1==null?0:l1.val;
            int l2Value = l2==null?0:l2.val;
            int value = l1Value+l2Value+g;
            g = value/10;
            int tmpValue = value%10;
            tmp.next = new ListNode(tmpValue);
            tmp = tmp.next;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        return res.next;
    }


    //删除倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast==null) return head.next;
        ListNode slow = head;
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    //用栈解决
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        stack.push(dummy);
        ListNode tmp = head;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (n-->0){
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        stack.clear();
        return dummy.next;
    }
    //哨兵
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        while (n-->0){
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        //头插法
        ListNode tmp = head;
        int n = 0;
        while (tmp!=null){
            n++;
            tmp = tmp.next;
        }
        ListNode dummy = new ListNode(0, head);
        int m = n/2;
        ListNode pre = dummy,cur = head;
        while (m-->0){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
    //递归解决
    public ListNode swapPairs1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs1(newNode.next);
        newNode.next = head;
        return newNode;
    }

    //旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        ListNode tail = head,newtail = head;
        int n = 1;
        while (tail.next!=null){
            tail = tail.next;
            n++;
        }
        // 原来的尾结点指向原来的头结点，形成环
        tail.next = head;
        // 找到断开环的位置
        for (int i = 0; i < n-(k%n)-1; i++) {
            newtail = newtail.next;
        }
        // 新的头结点指向断开环的位置
        ListNode newHead = newtail.next;
        newtail.next = null;
        return newHead;
    }

    //链表排序
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head.next,lastSorted = head;
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

    //去除重复元素链表
    public ListNode deleteDuplicates(ListNode head) {
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

    //链表求和
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if (l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        int up = 0;
        while (l1!=null||l2!=null||up==1){
            int l1Value = l1==null?0:l1.val;
            int l2Value = l2==null?0:l2.val;
            int value = l1Value+l2Value+up;
            int gvalue = value%10;
            up = value/10;
            tmp.next = new ListNode(gvalue);
            tmp = tmp.next;
            l1 = l1.next==null?null:l1.next;
            l2 = l2.next==null?null:l2.next;
        }
        return dummy.next;
    }

    //每k个一组反转
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1) return head;
        int len = 0;
        ListNode tmp = head;
        while (tmp!=null){
            len++;
            tmp = tmp.next;
        }
        int n = len/k;
        int m = k;
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy,cur = head;
        while (n-->0){
            while (m-->1){
                //头插法
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

    //合并k个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        return  null;
    }
}
