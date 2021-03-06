package q8c82a5b80378478f9484d87d1c5f12a4;

public class Solution {
    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public int jumpFloor(int target) {
        if(target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jumpFloor(target - 2) + jumpFloor(target - 1);
        }
    }
}
