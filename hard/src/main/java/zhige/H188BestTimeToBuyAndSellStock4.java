
package zhige;

/**
 *
 * 188. 买卖股票的最佳时机 IV
 *
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * 统一的状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 * @see E121BestTimeToBuyAndSellStock 买卖股票的最佳时机
 * @see M122BestTimeToBuyAndSellStock2 买卖股票的最佳时机 II
 * @see M309BestTimeToBuyAndSellStockWithCooldown 买卖股票的最佳时机含冷冻期
 * @see M714BestTimeToBuyAndSellStockWithTransactionFee 买卖股票的最佳时机含手续费
 * @see H123BestTimeToBuyAndSellStock3 买卖股票的最佳时机 III
 * @see H188BestTimeToBuyAndSellStock4 买卖股票的最佳时机 IV
 *
 * @author wangyongzhi
 * @date 2023/9/5
 */
public class H188BestTimeToBuyAndSellStock4 {

    /**
     * 今天没有持有：
     * 昨天就没有，今天不动
     * 昨天有，今天卖出
     * 今天持有：
     * 昨天没有，今天买入
     * 昨天又，今天不动。
     * <p>
     * 如果今天买入并且卖出，则认为没有交易。
     * 由于k有限制次数，那k也需要参与状态转移，穷举k的所有状态
     */
    public int maxProfit(int max_k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

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
