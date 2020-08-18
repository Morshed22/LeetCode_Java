import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists {
    public static void main(String[] args) {

    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        List<ListNode> res = new ArrayList<>();
//        while (lists.length > 1){
//           for(int i = 0; i < lists.length; i+= 2){
//               ListNode node = i+1 == lists.length ? null : lists[i+1];
//               res.add(megeTwoListNode(lists[i], node));
//           }
//           lists = res.toArray(new ListNode[0]);
//        }
//        return lists[0];
//    }
public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    return divideAndConquer(lists, 0, lists.length-1);
}
    public ListNode divideAndConquer(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[right];
        }else if (left+1 == right) {
            return megeTwoListNode(lists[left], lists[right]);
        }
        int mid = (left+right)/2;
        ListNode l1 = divideAndConquer(lists, left, mid);
        ListNode l2 = divideAndConquer(lists, mid+1, right);
        return megeTwoListNode(l1,l2);
    }

    ListNode megeTwoListNode(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null){
            head.next = l1.val < l2.val ? l1 : l2;
            if (head.next == l1) l1 = l1.next;
            else l2 = l2.next;
            head = head.next;
            head.next = null;
        }
        head.next = l1 != null ? l1 : l2;
        return temp.next;
    }
}
