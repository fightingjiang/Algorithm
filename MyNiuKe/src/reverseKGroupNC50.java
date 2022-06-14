public class reverseKGroupNC50 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) return head;
            ListNode res = new ListNode(0);
            res.next = head;
            int lenth = 0;
            ListNode pre = res, cur = head, tmp = null;
            while (head != null) {
                lenth++;
                head = head.next;
            }
            //使用头插法将链表反序
            for (int i = 0; i < lenth/k; i++) {
                for (int j = 1; j < k; j++) {
                    tmp = cur.next;
                    cur.next = tmp.next;
                    tmp.next = pre.next;
                    pre.next = tmp;
                }
                pre = cur;
                cur = cur.next;
            }
            return res.next;
        }
    }
