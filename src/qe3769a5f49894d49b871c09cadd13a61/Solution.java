package qe3769a5f49894d49b871c09cadd13a61;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// NC93 设计LRU缓存结构
// 直接使用LinkedHashMap实现
public class Solution {

    public static class LRUCache<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {
        private int cacheMaxSize = 0;

        public LRUCache(int cacheMaxSize) {
            super(cacheMaxSize * 2, 0.75f, true);
            this.cacheMaxSize = cacheMaxSize;
        }

        @Override
        protected boolean removeEldestEntry(Entry<K, V> eldest) {
            if (size() > cacheMaxSize) {
                return true;
            }
            return false;
        }

    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(k);
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] operator : operators) {
            int op = operator[0];
            int key = operator[1];
            if (op == 1) {
                int value = operator[2];
                cache.put(key, value);
            } else if (op == 2) {
                Integer r = cache.get(key);
                if (r != null) {
                    result.add(r);
                } else {
                    result.add(-1);
                }
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public static void main(String[] args) {

    }
}
