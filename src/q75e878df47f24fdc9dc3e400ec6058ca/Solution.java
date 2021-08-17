package q75e878df47f24fdc9dc3e400ec6058ca;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        ListNode root = stack.pop();
        head = root;
        while (!stack.empty()) {
            try {
                head.next = stack.peek();
                head = stack.pop();
            } catch (EmptyStackException e) {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new Solution().ReverseList(head));;
    }
}
