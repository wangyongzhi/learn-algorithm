package zhige;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * https://leetcode.cn/problems/subsets/
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
 * @date 2023/9/21
 */
public class M74Subsets {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        M74Subsets m74Subsets = new M74Subsets();
        List<List<Integer>> subsets = m74Subsets.subsets(arr);
        System.out.println(subsets);
    }
}
