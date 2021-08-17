package qd8b6b4358f774294a89de2a6ac4d9337;

public class Solution {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode root, tmp;
        if (list1.val > list2.val) {
            root = list2;
            list2 = list2.next;
        } else {
            root = list1;
            list1 = list1.next;
        }
        tmp = root;
        while (true) {
            if (list1 == null) {
                root.next = list2;
                break;
            }
            if (list2 == null) {
                root.next = list1;
                break;
            }
            if (list1.val > list2.val) {
                root.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                root.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            root = root.next;
        }
        return tmp;
    }
}