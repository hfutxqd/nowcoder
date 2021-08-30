package q253d2c59ec3e4bc68da16833f79a38e4;

// NC3 链表中环的入口结点
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针首次相遇后，保持慢指针不动，重置快指针到链表头部，然后将快指针的步进调整为1，重新开始遍历
     * 相遇时，该节点即为环的入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        boolean findingEntry = false;
        while (true) {
            if (slow == null|| fast == null || fast.next == null) {
                return null;
            }
            if (slow == fast) { // 相遇时再跑一圈
                if (!findingEntry) {
                    findingEntry = true;
                    fast = pHead;
                } else {
                    return slow;
                }
            }
            slow = slow.next;
            if (!findingEntry) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
    }

}
