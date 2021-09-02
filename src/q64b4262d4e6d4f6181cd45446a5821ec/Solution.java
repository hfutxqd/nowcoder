package q64b4262d4e6d4f6181cd45446a5821ec;


// 买卖股票的最好时机
public class Solution {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int[] profits = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            profits[i] = prices[i + 1] - prices[i]; // 每天的利润
        }
        int max = -1;
        int sum = -1;
        for(int i = 0;i < profits.length ; i++){//将利润值进行循环判断
            if(sum > 0) {
                sum += profits[i]; //利润叠加
            } else { // 出现亏损
                sum = profits[i]; // 重新购入
            }
            if(sum > max) {
                max = sum;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 1, 2, 2, 3, 0}));
        System.out.println(new Solution().maxProfit(new int[]{4, 5, 1, 4, 1, 2, 1}));
    }
}
