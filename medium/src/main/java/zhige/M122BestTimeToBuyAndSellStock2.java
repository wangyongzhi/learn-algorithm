package zhige;

/**
 *
 * 122. 买卖股票的最佳时机 II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
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
public class M122BestTimeToBuyAndSellStock2 {

    /**
     * 今天没有持有：
     *      昨天就没有，今天不动
     *      昨天有，今天卖出
     * 今天持有：
     *      昨天没有，今天买入
     *      昨天又，今天不动。
     *
     * 如果今天买入并且卖出，则认为没有交易。
     * 可以持续买卖，则k取正无穷，可以理解为k 等于 k-1
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
            //第1天如果持有，取昨天持有今天不动， 与 昨天没有今天买入的价格，买入记录为负值。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] -prices[i]);
        }

        //最后肯定是没有持有的
        return dp[n - 1][0];


    }
}
