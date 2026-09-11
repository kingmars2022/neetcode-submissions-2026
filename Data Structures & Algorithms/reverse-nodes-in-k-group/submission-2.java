/*
1. 检查当前是否至少还有 k 个节点
2. 递归处理后面的链表
3. 反转当前这 k 个节点，并接到后面
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;

        for (int i = 0; i < k; i++) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }

        ListNode prev = reverseKGroup(node, k);
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}