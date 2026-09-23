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
public class Solution {
    private ListNode[] reverseList(ListNode node, int n) {
        if (n == 1) {
            return new ListNode[] { node, node.next };
        }
        ListNode[] result = reverseList(node.next, n - 1);
        node.next.next = node;
        node.next = result[1];
        return new ListNode[] { result[0], node.next };
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseList(head, right)[0];
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}