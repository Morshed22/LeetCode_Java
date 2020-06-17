
public class ListNode {
    static ListNode head;
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void push(int val)
    {
        ListNode new_node = new ListNode(val);
        new_node.next = head;
        head = new_node;
    }
    public void printList()
    {
        ListNode tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.val + " ");
            tnode = tnode.next;
        }
    }

    public ListNode removeElements(int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, next = head;
        while (next != null){
            if (next.val == val){
                cur.next = next.next;
            }else {
                cur = next;
            }
            next = next.next;
        }
        head = dummy.next;
        printList();
        return head ;
    }
}