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


//Approach - 1: dummy Node and fista and second pointer
//Time Complexity : O(L)
//Space Complexity : O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //create a dummy Node;
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        //loop length-n ==> 5-2 ==3
        for(int i=0; i<=n; i++){
            first = first.next;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}