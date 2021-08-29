package qb49c3dc907814e9bbfa8437c251b028e;

import java.util.LinkedList;

public class Solution2 {

    public static class ListNode {
      int val;
      ListNode next = null;
    }

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

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;
        int count = 0;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
            count++;
        }
        return pre;
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        LinkedList<ListNode> kList = new LinkedList<>();
        ListNode root = head;
        int curr = 0;
        boolean reverseLast = true;
        while (root != null) {
            if (curr % k == 0) {
                kList.add(root);
            }
            if ((curr + 1 ) % k == 0) {
                ListNode tmp = root.next;
                root.next = null;
                root = tmp;
            } else if (root.next == null) {
                reverseLast = false;
                ListNode tmp = root.next;
                root.next = null;
                root = tmp;
            } else {
                root = root.next;
            }
            curr++;
        }
        curr = 0;
        ListNode last = null, result = null;
        for (ListNode node: kList) {
            if (curr == kList.size() - 1 && !reverseLast) { // 最后一组
                if (result == null) {
                    result = node;
                }
                if (last != null) {
                    last.next = node;
                }
                break;
            }
            ListNode tmp = ReverseList(node);
            if (result == null) {
                result = tmp;
            }
            if (last != null) {
                last.next = tmp;
            }
            last = node;
            curr++;
        }
        return result;
    }

    public static void main(String[] args) {
        printNode(new Solution2().reverseKGroup(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 4));
        System.out.println();
        printNode(new Solution2().reverseKGroup(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 3));
        System.out.println();
        printNode(new Solution2().reverseKGroup(createNode(new int[]{1, 2, 3}), 3));
        System.out.println();
        printNode(new Solution2().reverseKGroup(createNode(new int[]{1, 2}), 3));


    }
}
