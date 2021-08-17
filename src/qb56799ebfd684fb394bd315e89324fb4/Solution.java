package qb56799ebfd684fb394bd315e89324fb4;

import java.util.HashMap;

public class Solution {
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
