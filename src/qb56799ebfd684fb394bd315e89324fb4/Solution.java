package qb56799ebfd684fb394bd315e89324fb4;

import java.util.HashMap;

// NC41 最长无重复子数组
public class Solution {
//    给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
//    子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组

    public int maxLength (int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int left = 0, result = 1;
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0 ; i < arr.length; i++) {
            int val = arr[i];
            if (visited.containsKey(val) && visited.get(val) + 1 > left) {
                left = visited.get(val) + 1;
            }
            visited.put(val, i);
            if (i - left + 1 > result) {
                result = i - left + 1;
            }
        }
        return result;
    }
}
