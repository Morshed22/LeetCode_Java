public class AddTwoNumbers {
    public static void main(String[] args) {

    }


    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode list = new ListNode(-1);
            ListNode temp = list;
            int carry = 0;
            while(l1 != null || l2 != null){
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
               int curVal = carry + (x+y)%10;
                ListNode newNode = new ListNode(curVal);
                carry = (x+y)/10;
                list.next = newNode;
                list = list.next;
                if (l1 != null ) l1 = l1.next;
                if (l2 != null ) l2 = l2.next;
            }
            if (carry > 0){
                ListNode newNode = new ListNode(carry);
                list.next = newNode;
                list = list.next;
            }
            return temp.next;
        }
    }

}
