/*
先走 k 步
↓
不够 k 个：原样返回
↓
够 k 个：递归处理后面
↓
后面处理完成后，反转当前 k 个
↓
把当前组接到后面
↓
返回当前组的新头
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