package qf95dcdafbde44b22a6d741baf71653f6;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {


    static class ListNode {
      int val;
      ListNode next = null;
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmpHead = head;
        while (tmpHead != null) {
            stack.push(tmpHead);
            tmpHead = tmpHead.next;
        }
        int current = 0;
        while (!stack.empty()) {
            tmpHead = stack.pop();
            current++;
            if (current == n) {
                try {
                    ListNode parent = stack.pop();
                    parent.next = tmpHead.next;
                } catch (EmptyStackException e) {
                    head = tmpHead.next;
                }
            }
        }
        return head;
    }
}