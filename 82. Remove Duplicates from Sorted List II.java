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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle cases where the head itself needs to be removed
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // Check if head is the start of a duplicate sequence
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the duplicate value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after the duplicates
                prev.next = head.next;
            } else {
                // Move prev pointer if head is distinct
                prev = prev.next;
            }
            // Move to the next node
            head = head.next;
        }

        return dummy.next;
    }
}
