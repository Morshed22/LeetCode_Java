public class RemoveLinkedListElement {
    ListNode llist = new ListNode();
    public static void main(String[] args) {

        ListNode llist = new ListNode();

        llist.push(7);
        llist.push(2);
        llist.push(3);
        llist.push(2);
        llist.push(8);
        llist.push(1);
        llist.push(2);
        llist.push(2);

       llist.removeElements(2);
    }

    public  static ListNode removeElements(ListNode head, int val) {

            head.printList();
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy, next = head;
            while (next != null){
                if (next.val == val){
                    cur.next = next.next;
                }else {
                    cur = cur.next;
                }
                next = next.next;
            }
            System.out.println("\n");
        dummy.next.printList();
        return dummy.next ;
    }

}


