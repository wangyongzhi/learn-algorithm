package zhige;

/**
 *
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * @author wangyongzhi
 * @date 2023/9/23
 */
public class M53MaximumSubarray {

    /**
     * 方法2：对方法1进行优化，因为dp[i]只与dp[i-1]有关，可以用空间压缩技巧把空间复杂度降到O(1)。
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;

        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }

        return res;
    }

    /**
     * 方法1：最大子数组，其实需要判断的是i-1的子数组和加上当前值 与 当前值的大小。
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
