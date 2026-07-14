/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode prev = dummy;
        int carry = 0;

        while(l1!=null || l2!=null){
            int sum = carry;

            if(l1!=null) sum += l1.val;
            if(l2!=null) sum += l2.val;

            carry = sum/10;

            if(l1 == null){
                prev.next = l2;
                l1=l2;
            }
            l1.val = sum%10;
        prev = l1;
        l1 = l1.next;
        if(l2!=null) l2 = l2.next;
        }
        if(carry>0){
           prev.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
