package q6a296eb82cf844ca8539b57c23e6e9bf;

import java.util.ArrayList;


// NC119
// 选择排序解法
public class Solution {

//    给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
//            0 <= k <= input.length <= 10000
//            0 <= input[i] <= 10000

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 选择排序算法特点：
        // 每次每一次循环能在为排序区找到最小的值
        // 所以循环k次即可
        for (int i = 0; i < k; i++) {
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
