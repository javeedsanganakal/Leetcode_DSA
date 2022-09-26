/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Approach - 1: HashSet
//Time Complexity : O(n) // Traversing the nodes in linkedlist
//Space Complexity : O(n) // HashSet

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}