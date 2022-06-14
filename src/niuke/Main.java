package niuke;

public class Main {

    //反转链表
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null,cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
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
        return res.next;
    }

    //递归实现
    public ListNode mergeTwoLists1 (ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            ListNode tmp = l1;
            tmp.next = mergeTwoLists(l1.next,l2);
            return tmp;
        }else {
            ListNode tmp = l2;
            tmp.next = mergeTwoLists(l1,l2.next);
            return tmp;
        }
    }
}
