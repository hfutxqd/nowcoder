package q2baf799ea0594abd974d37139de27896;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        // write code here
        for (int i = arr.length - 1; i >= 0; i++) {
            int max = arr[0], maxPos = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxPos = j;
                }
            }
        }



        return arr;
    }
}