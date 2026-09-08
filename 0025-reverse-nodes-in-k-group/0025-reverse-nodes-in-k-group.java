class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;

        // Check if there are at least k nodes
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // Fewer than k nodes → leave them unchanged
        if (count < k) {
            return head;
        }

        // Reverse k nodes
        ListNode prev = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // head is now the last node of the reversed group
        head.next = reverseKGroup(current, k);

        return prev;
    }
}