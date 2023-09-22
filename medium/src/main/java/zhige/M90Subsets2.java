package zhige;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * https://leetcode.cn/problems/subsets-ii/
 *
 * @see M46Permutations
 * @see M47Permutations2
 * @see M74Subsets
 * @see M90Subsets2
 * @see M77Combinations
 * @see M39CombinationSum
 * @see M40CombinationSum2
 *
 * @author wangyongzhi
 * @date 2023/9/22
 */
public class M90Subsets2 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums, int start) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
