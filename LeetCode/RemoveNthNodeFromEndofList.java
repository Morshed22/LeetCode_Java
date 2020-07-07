
public class RemoveNthNodeFromEndofList {
     Node head;

    /* Linked List node */
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void printList()
    {
        Node tempNode = head;
        while (tempNode != null)
        {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }

    void printNthFromLast(int n)
    {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref_ptr == null) {
                    System.out.println(n + " is greater than the no "
                            + " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. " + n + " from last is " + main_ptr.data);
        }
    }
    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node fisrt = dummy;
        Node second = dummy;
        for (int i = 1; i<= n+1; i++){
            fisrt = fisrt.next;
        }
        while (fisrt != null){
            fisrt = fisrt.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
//    void printNthFromLast(int n)
//    {
//        int len = 0;
//        Node temp = new Node(0);
//          temp.next = head;
//
//        Node p = head;
//        while (p != null){
//            p = p.next;
//            len++;
//        }
//      len = len-n;
//      p = temp;
//      while (len > 0){
//          p = p.next;
//          len--;
//      }
//      p.next = p.next.next;
//      head = temp.next;
//    }
        /*Driver program to test above methods */
    public static void main(String[] args)
    {
        RemoveNthNodeFromEndofList llist = new RemoveNthNodeFromEndofList();
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.printNthFromLast(3);
        llist.printList();
    }

}

