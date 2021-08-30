package q2820ea076d144b30806e72de5e5d4bbf;

public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack (int V, int n, int[][] vw) {
        // dp矩阵代表 背包的体积 与 前i个物品 的最优解
        int[][] dp = new int[n][V];

        // V为0时，不论物品如何，最大重量为0
        // dp[i][0]代表 背包的体积 为0时，最优解均为0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // 考虑第1个物品，背包容量容量变化与最大重量的关系
        int v = vw[0][0];
        int w = vw[0][1];
        for (int i = 0; i < V; i++) {
            // dp[0][i]代表体积为i时，前0个物体的最优解
            if ( v <= i) { // 物品可以放进背包，则最优解为第0个物体的重量
                dp[0][i] = w;
            } else {  // 物品不可以放进背包，则最优解为0
                dp[0][i] = 0;
            }
        }
        // 递推公式
        // dp[i][j] = max of
        // 1.第i个物品不放进背包： dp[i - 1][j]
        // 2.第i个物品放进背包：  dp[i - 1][j - v] + w
        for (int i = 1; i < n; i++) { // i表示物品
            for (int j = 1; j < V; j++) { // j表示背包容量
                v = vw[i][0];
                w = vw[i][1];
                if (v >= j) { // 物体体积可以放进背包
                    int a = dp[i - 1][j]; // 不放的情况
                    int b = dp[i - 1][j - v] + w;  // 放的情况
                    dp[i][j] = Math.max(a, b);
                } else { // 物体体积过大，放不进背包
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n - 1][V];
    }
}