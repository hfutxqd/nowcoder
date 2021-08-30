package q8a2b2bf6c19b4f23a9bdb9b233eefa73;

// LC45 二叉树的最大深度
// 递归解法
public class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int maxDepth (TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        return maxDepth(root, 0);
    }
}
