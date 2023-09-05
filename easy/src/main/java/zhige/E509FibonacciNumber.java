package zhige;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * https://leetcode.cn/problems/fibonacci-number/
 * @author wangyongzhi
 * @date 2023/9/4
 */
public class E509FibonacciNumber {


    /**
     * 可以用通项公式算出结果第n条的结果。
     * https://leetcode.cn/problems/fibonacci-number/solutions/545049/fei-bo-na-qi-shu-by-leetcode-solution-o4ze/
     *
     * @param n
     * @return
     */
    public int fib5(int n) {
        return 0;
    }

    /**
     * 方法4：迭代解法，优化空间复杂度为O(1)
     *
     * 相较于方法3的优势，方法3其实还是保留了整个数组的结果，其实最终结果只跟前面两个数字有关，只需要两个变量即可。
     *
     */
    public int fib4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int pre = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int res = pre + curr;
            pre = curr;
            curr = res;
        }

        return curr;
    }

    /**
     * 方法3：数组的迭代解法，时间复杂度N，空间复杂度N
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }



    /**
     * 方法2：备忘录解法。
     * 把已经算过的通过一个备忘录记录下来，时间复杂度为N，空间复杂度为N
     */
    public int fib2(int n) {
        int[] tmp = new int[n + 1];
        return fibB(tmp, n);
    }

    /**
     * 方法B：把已经算过的通过一个备忘录记录下来，时间复杂度为N，空间复杂度为N
     */
    public int fibB(int[] tmp, int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (tmp[n] != 0) {
            return tmp[n];
        }

        int resultN = fibB(tmp, n - 1) + fibB(tmp,n - 2);
        tmp[n] = resultN;

        return resultN;
    }


    /**
     * 方法1：直接用题中的公式代入，性能较差，时间复杂度 2的n次方指数复杂度。
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

}
