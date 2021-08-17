package q04a5560e43e24e9db4595865dc9c63a3;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<Integer> level = new ArrayDeque<>();
        queue.add(root);
        level.add(0);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            int l = level.pop();
            ArrayList<Integer> tmp;
            if (l >= result.size()) {
                tmp = new ArrayList<>();
                result.add(l, tmp);
            } else {
                tmp = result.get(l);
            }
            tmp.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                level.add(l + 1);
            }
            if(node.right != null){
                queue.add(node.right);
                level.add(l + 1);
            }
        }
        return result;
    }
}