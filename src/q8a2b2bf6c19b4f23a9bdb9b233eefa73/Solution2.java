package q8a2b2bf6c19b4f23a9bdb9b233eefa73;

import java.util.Stack;

// LC45 二叉树的最大深度
// 非递归解法
public class Solution2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levelStack= new Stack<>();
        stack.push(root);
        levelStack.push(1);
        int maxLevel = 0;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            Integer level = levelStack.pop();
            if (level > maxLevel) {
                maxLevel = level;
            }
            if (node.left != null) {
                stack.push(node.left);
                levelStack.push(level + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                levelStack.push(level + 1);
            }
        }
        return maxLevel;
    }
}
