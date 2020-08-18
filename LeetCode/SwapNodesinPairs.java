public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode ahead = cur;
        ListNode p,q;
        while (cur.next != null && cur.next.next != null){
            p = cur.next;
            q = cur.next.next;
            p.next = q.next;
            q.next = p;
            cur.next = q;
            cur = p;
        }
        return ahead.next;
    }
}
