package q64b4262d4e6d4f6181cd45446a5821ec;


// 买卖股票的最好时机
public class Solution2 {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int min = Integer.MAX_VALUE; // 历史最低价
        int max = -1;
        for(int i = 0;i < prices.length ; i++){//将利润值进行循环判断
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) { // 当前的最大利润为当前价格-历史最低价
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{1, 2, 1, 2, 2, 3, 0}));
        System.out.println(new Solution2().maxProfit(new int[]{4, 5, 1, 4, 1, 2, 1}));
    }
}
