package zhige;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * https://leetcode.cn/problems/combination-sum-ii/
 *
 * @see M46Permutations 全排列
 * @see M47Permutations2 全排列 II
 * @see M74Subsets 子集
 * @see M90Subsets2 子集 II
 * @see M77Combinations 组合
 * @see M39CombinationSum 组合总和
 * @see M40CombinationSum2 组合总和 II
 *
 * @author wangyongzhi
 * @date 2023/9/22
 */
public class M40CombinationSum2 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    // 记录 track 中的元素之和
    int trackSum = 0;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backtrack(candidates, 0,target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        // base case，超过目标和，直接结束
        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            trackSum = trackSum + candidates[i];
            backtrack(candidates, i + 1, target);
            track.removeLast();
            trackSum = trackSum - candidates[i];
        }
    }
}
