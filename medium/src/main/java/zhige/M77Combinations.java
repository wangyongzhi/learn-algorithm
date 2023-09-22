package zhige;

import java.util.LinkedList;
import java.util.List;

/**
 *77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * https://leetcode.cn/problems/combinations/
 *
 * @see M46Permutations
 * @see M74Subsets
 * @see M77Combinations
 *
 * @author wangyongzhi
 * @date 2023/9/22
 */
public class M77Combinations {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        //base case
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 通过 start 参数控制树枝的遍历，避免产生重复的子集
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        M77Combinations m = new M77Combinations();
        List<List<Integer>> combine = m.combine(4, 2);
        System.out.println(combine);
    }

}












