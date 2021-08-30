package q0bf071c135e64ee2a027783b80bf781d;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 二叉树的中序遍历
 * 非递归实现
 */
public class Solution2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[] {};
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) { // 将左子树入栈
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); // 层数最深的左节点
            result.add(curr.val);
            curr = curr.right;
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
