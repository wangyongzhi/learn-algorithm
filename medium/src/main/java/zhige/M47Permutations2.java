package zhige;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * https://leetcode.cn/problems/permutations-ii/
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
public class M47Permutations2 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            //!used[i - 1] 是为了保证相同元素在排列中的相对位置保持不变。2在2'前面
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
