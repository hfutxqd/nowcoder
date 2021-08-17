package qcf4091ca75ca47958182dae85369c82c;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求出a、b的最大公约数。
     * @param a int
     * @param b int
     * @return int
     */
    public int gcd (int a, int b) {
        while(a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
}