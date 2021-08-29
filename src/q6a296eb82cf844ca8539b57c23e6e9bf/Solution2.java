package q6a296eb82cf844ca8539b57c23e6e9bf;

import java.util.*;

// NC119
// 堆排序解法
public class Solution2 {

//    给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
//            0 <= k <= input.length <= 10000
//            0 <= input[i] <= 10000

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>(k);
        if (k == 0) {
            return result;
        }
        if (input.length <= k) {
            for (int n: input) {
                result.add(n);
            }
            return result;
        }
        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int n: input) {
            if(heap.isEmpty() || heap.size() < k){
                heap.offer(n);
            } else if (n < heap.peek()) {
                heap.offer(n);
                heap.poll();
            }
        }
        result.addAll(heap);
        return result;
    }
}
