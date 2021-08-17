package q91b69814117f4e8097390d107d2efbe0;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        while (!deque.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            // 打印奇数层
            // 这里有一个巧妙的设计，deque.size()是i的初始值，add/remove操作不会影响循环次数
            // 相当于完成了一层的遍历，并把下一层的节点放入队列
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右，取队头
                TreeNode n = deque.removeFirst();
                tmp.add(n.val);

                // 先左后右加入下层节点
                // 为什么要先左后右？
                // 因为当前访问顺序是从左到右，先左后右放入可以保证顺序不会被打乱
                if(n.left != null) {
                    deque.addLast(n.left);
                }
                if(n.right != null) {
                    deque.addLast(n.right);
                }
            }
            result.add(tmp);
            if(deque.isEmpty()) break;

            tmp = new ArrayList<>();
            // 打印偶数层
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode n = deque.removeLast();
                tmp.add(n.val);

                // 先右后左加入下层节点
                // 与上同理
                if(n.right != null) {
                    deque.addFirst(n.right);
                }
                if(n.left != null) {
                    deque.addFirst(n.left);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
