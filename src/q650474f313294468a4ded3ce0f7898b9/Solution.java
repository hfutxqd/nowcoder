package q650474f313294468a4ded3ce0f7898b9;

// NC4 判断链表中是否有环
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (slow == null|| fast == null || fast.next == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
