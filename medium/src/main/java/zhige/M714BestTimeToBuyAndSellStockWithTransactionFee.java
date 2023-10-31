package zhige;

/**
 *
 *
 * 714. 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @see E121BestTimeToBuyAndSellStock 买卖股票的最佳时机
 * @see M122BestTimeToBuyAndSellStock2 买卖股票的最佳时机 II
 * @see M309BestTimeToBuyAndSellStockWithCooldown 买卖股票的最佳时机含冷冻期
 * @see M714BestTimeToBuyAndSellStockWithTransactionFee 买卖股票的最佳时机含手续费
 * @see H123BestTimeToBuyAndSellStock3 买卖股票的最佳时机 III
 * @see H188BestTimeToBuyAndSellStock4 买卖股票的最佳时机 IV
 *
 *  * @author wangyongzhi
 *  * @date 2023/9/5
 */
public class M714BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 今天没有持有：
     *      昨天就没有，今天不动
     *      昨天有，今天卖出
     * 今天持有：
     *      昨天没有，今天买入
     *      昨天又，今天不动。
     *
     * 可以持续买卖，则k取正无穷，可以理解为k 等于 k-1
     *
     * 比{@linkplain  M122BestTimeToBuyAndSellStock2} 这种场景加了个条件限制，即冷冻期为 1 天。
     * 则买入的dp 则要从i-2算起
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        //记录利润
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            //由于存在i-2，则需要初始化前两条数据。
            if (i == 0) {
                //第一天，如果没有买入，则利润为0
                dp[i][0] = 0;
                //第一天，如果买入了，则利润记为负prices[0]
                dp[i][1] = -prices[i] - fee;
                continue;
            }
//            if (i == 1) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//                continue;
//            }
            //第i天如果没有持有，取昨天没有持有今天不动 与 昨天持有并且加上今天卖出的价格，卖出记录为正值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第1天如果持有，取昨天持有今天不动， 与 昨天没有今天买入的价格，买入记录为负值，并且减去手续费。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        //最后肯定是没有持有的
        return dp[n - 1][0];


    }
}
