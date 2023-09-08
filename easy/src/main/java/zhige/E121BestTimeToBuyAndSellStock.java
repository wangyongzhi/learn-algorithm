package zhige;

/**
 *
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * 统一的状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 * @see E121BestTimeToBuyAndSellStock
 * @see M122BestTimeToBuyAndSellStock2
 * @see M309BestTimeToBuyAndSellStockWithCooldown
 * @see M714BestTimeToBuyAndSellStockWithTransactionFee
 * @see H123BestTimeToBuyAndSellStock3
 * @see H188BestTimeToBuyAndSellStock4
 *
 *  * @author wangyongzhi
 *  * @date 2023/9/5
 */
public class E121BestTimeToBuyAndSellStock {

    /**
     * 今天没有持有：
     *      昨天就没有，今天不动
     *      昨天有，今天卖出
     * 今天持有：
     *      昨天没有，今天买入
     *      昨天又，今天不动。
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        //记录利润
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                //第一天，如果没有买入，则利润为0
                dp[i][0] = 0;
                //第一天，如果买入了，则利润记为负prices[0]
                dp[i][1] = -prices[i];
                continue;
            }
            //第i天如果没有持有，取昨天没有持有今天不动 与 昨天持有并且加上今天卖出的价格，卖出记录为正值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第1天如果持有，取昨天持有今天不动， 与 昨天没有今天买入的价格，买入记录为负值，只买一次，直接用当前值的负数即可。
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        //最后肯定是没有持有的
        return dp[n - 1][0];


    }
}
