package zhige;

/**
 *
 * 309. 买卖股票的最佳时机含冷冻期
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author wangyongzhi
 * @date 2023/9/5
 *
 *  @see E121BestTimeToBuyAndSellStock
 *  @see E122BestTimeToBuyAndSellStock2
 *  @see E714BestTimeToBuyAndSellStockWithTransactionFee
 */
public class E309BestTimeToBuyAndSellStockWithCooldown {

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
     *
     * 比{@linkplain  E122BestTimeToBuyAndSellStock2} 这种场景加了个条件限制，即冷冻期为 1 天。
     * 则买入的dp 则要从i-2算起
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        //记录利润
        int[][] dp = new int[length][2];

        for (int i = 0; i < length; i++) {
            //由于存在i-2，则需要初始化前两条数据。
            if (i == 0) {
                //第一天，如果没有买入，则利润为0
                dp[0][0] = 0;
                //第一天，如果买入了，则利润记为负prices[0]
                dp[0][1] = -prices[0];
                continue;
            }
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
            //第i天如果没有持有，取昨天没有持有今天不动 与 昨天持有并且加上今天卖出的价格，卖出记录为正值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第1天如果持有，取昨天持有今天不动， 与 昨天没有今天买入的价格，买入记录为负值。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] -prices[i]);
        }

        //最后肯定是没有持有的
        return dp[length - 1][0];


    }
}
