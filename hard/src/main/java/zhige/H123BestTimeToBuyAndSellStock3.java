
package zhige;

/**
 *
 * 123. 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
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
 * @author wangyongzhi
 * @date 2023/9/5
 */
public class H123BestTimeToBuyAndSellStock3 {

    /**
     * 今天没有持有：
     *      昨天就没有，今天不动
     *      昨天有，今天卖出
     * 今天持有：
     *      昨天没有，今天买入
     *      昨天又，今天不动。
     *
     * 如果今天买入并且卖出，则认为没有交易。
     * 由于k有限制次数，那k也需要参与状态转移，穷举k的所有状态
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max_k = 2;

        int n = prices.length;
        //记录利润
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i == 0) {
                    //第一天，如果没有买入，则利润为0
                    dp[i][k][0] = 0;
                    //第一天，如果买入了，则利润记为负prices[0]
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                //第i天如果没有持有，取昨天没有持有今天不动 与 昨天持有并且加上今天卖出的价格，卖出记录为正值
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                //第1天如果持有，取昨天持有今天不动， 与 昨天没有今天买入的价格，买入记录为负值。
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        //最后肯定是没有持有的
        return dp[n - 1][max_k][0];
    }
}
