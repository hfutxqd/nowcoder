package qe3769a5f49894d49b871c09cadd13a61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// NC93 设计LRU缓存结构
// 直接使用HashMap+双向链表实现
public class Solution2 {

    public static class Node {
        Node pre;
        Node next;
        int key, value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class LRUCache {
        private int cacheSize;
        private HashMap<Integer, Node> data;
        private Node head, foot;

        public LRUCache(int cacheSize) {
            this.cacheSize = cacheSize;
            this.data = new HashMap<>(cacheSize);
            this.head = new Node(-1, -1);
            this.foot = new Node(-1, -1);
            this.head.next = this.foot;
            this.foot.pre = this.head;
        }

        private void moveToHead(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        private void removeNode(Node node) {
            Node next = node.next;
            Node pre = node.pre;
            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
            }
            if (next == null) {
                foot = pre;
            } else {
                next.pre = pre;
            }

            node.pre = null;
            node.next = null;
            data.remove(node.key);
        }

        public int get(int key) {
            if (data.containsKey(key)) {
                Node node = data.get(key);
                this.moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (data.containsKey(key)) {
                Node node = data.get(key);
                node.value = value;
            } else {
                if (data.size() == cacheSize) {
                    this.removeNode(foot.pre);
                }
                Node node = new Node(key, value);
                node.pre = head;
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                data.put(key, node);
            }

        }
    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        LRUCache cache = new LRUCache(k);
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] operator : operators) {
            int op = operator[0];
            int key = operator[1];
            if (op == 1) {
                int value = operator[2];
                cache.set(key, value);
            } else if (op == 2) {
                result.add(cache.get(key));
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {
                {1, 1, 1},{1, 2, 2},{1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}
        };
        System.out.println(Arrays.toString(new Solution2().LRU(data, 3)));
    }
}
