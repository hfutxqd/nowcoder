package qa9fec6c46a684ad5a3abd4e365a9d362;

import java.util.ArrayList;
import java.util.List;

// NC45
public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            preOrder(root.left, result);
        }
        if (root.right != null) {
            preOrder(root.right, result);
        }
    }

    public void midOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midOrder(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            midOrder(root.right, result);
        }
    }

    public void afterOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            afterOrder(root.left, result);
        }
        if (root.right != null) {
            afterOrder(root.right, result);
        }
        result.add(root.val);
    }

    public int[] list2arr(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();
        ArrayList<Integer> after = new ArrayList<>();
        preOrder(root, pre);
        midOrder(root, mid);
        afterOrder(root, after);
        int[][] result = new int[3][];
        result[0] = list2arr(pre);
        result[1] = list2arr(mid);
        result[2] = list2arr(after);

        return result;
    }
}