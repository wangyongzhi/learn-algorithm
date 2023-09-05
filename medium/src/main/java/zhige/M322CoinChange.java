package zhige;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * https://leetcode.cn/problems/coin-change/
 *
 *
 * 假如硬币数字为 1、2、5，凑出11，可以分解成：
 * 凑成10、9、6的最小值，再加1枚硬币（1、2、5） 即可
 * @author wangyongzhi
 * @date 2023/9/5
 */
public class M322CoinChange {


    /**
     * 方法2：dp 数组的迭代解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1。
        // 为啥 dp 数组中的值都初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
        // 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
        // 为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？因为后面有 dp[i - coin] + 1，这就会导致整型溢出。
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 方法1：备忘录方式。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        //定义一个备忘录
        int[] memo = new int[amount + 1];
        //取一个不会用到的值。
        Arrays.fill(memo, -2);
        return dp(memo, coins, amount);
    }

    private int dp(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        //如果重复，直接取值。
        if (memo[amount] != -2) {
            return memo[amount];
        }


        //定义一个结果，默认值为int最大值，因为最终取的是最小值，需要用min方法判断结果
        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            //子问题结果
            int subResult = dp(memo, coins, amount - coin);
            //如果结果为-1，跳过
            if (subResult == -1) {
                continue;
            }

            result = Math.min(result, 1 + subResult);

        }
        //把结果存备忘录
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }
}
