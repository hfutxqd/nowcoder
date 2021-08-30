package q0bf071c135e64ee2a027783b80bf781d;

import java.util.ArrayList;


/**
 * 二叉树的中序遍历
 * 递归实现
 */
public class Solution {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    public void inorderTraversal (TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return new int[] {};
        }
        inorderTraversal(root, result);
        int[] tmp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            tmp[i] = result.get(i);
        }
        return tmp;
    }
}
