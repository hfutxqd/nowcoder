package qb49c3dc907814e9bbfa8437c251b028e;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static class ListNode {
      int val;
      ListNode next = null;
    }

    // TODO: 2021/8/15 未通过
//    描述
//    将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
//    如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
//    你不能更改节点中的值，只能更改节点本身。
//    要求空间复杂度 O(1)

    public static void printNode(ListNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printNode(root.next);
        }
    }

    public static ListNode  createNode(int[] arr) {
        ListNode root = new ListNode();
        root.val = arr[0];
        ListNode tmp = root;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode();
            tmp.next .val = arr[i];
            tmp = tmp.next;
        }
        return root;
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;
        HashMap<Integer, ListNode> lastMap = new HashMap<>();
        int group = 0;
        while (cur != null) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    lastMap.put(group, cur);
                }
                nex = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nex;
            }
            if (group == 0) {
                head = pre;
            } else {
                lastMap.get(group - 1).next = pre;
            }

            group++;
        }
        return head;
    }

    public static void main(String[] args) {
        printNode(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println();
        printNode(new Solution().reverseKGroup(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 4));

    }
}
