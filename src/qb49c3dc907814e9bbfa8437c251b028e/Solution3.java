package qb49c3dc907814e9bbfa8437c251b028e;

public class Solution3 {

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

    public ListNode reverseList(ListNode a, ListNode b) {
        ListNode pre = b;
        ListNode cur = a;
        ListNode nex = null;
        while (cur != b) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode node = head;
        // 循环结束，node为下一组的头部
        for (int i = 0; i < k; i++) {
            if (node != null) {
                node = node.next;
            } else {
                return head;
            }
        }
        // res为反转后的头部
        ListNode res = reverseList(head, node);
        // 反转后head为尾部
        head.next = reverseKGroup(node, k);
        return res;
    }

    public static void main(String[] args) {
        printNode(new Solution3().reverseKGroup(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}), 4));
        System.out.println();
        printNode(new Solution3().reverseKGroup(createNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 3));
        System.out.println();
        printNode(new Solution3().reverseKGroup(createNode(new int[]{1, 2, 3}), 3));
        System.out.println();
        printNode(new Solution3().reverseKGroup(createNode(new int[]{1, 2}), 3));


    }
}
