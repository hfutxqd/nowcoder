package q6a296eb82cf844ca8539b57c23e6e9bf;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        for (int i = 0; i <k; i++) {
            int minPos = i;
            for (int j = i; j < input.length; j++) {
                if (input[minPos] > input[j]) {
                    minPos = j;
                }
            }
            int tmp = input[minPos];
            input[minPos] = input[i];
            input[i] = tmp;
        }
        ArrayList<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
}
