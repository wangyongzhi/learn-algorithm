package zhige;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.cn/problems/permutations/
 *
 * @see M46Permutations
 * @see M74Subsets
 * @see M77Combinations
 *
 * @author wangyongzhi
 * @date 2023/9/21
 */
public class M46Permutations {

    List<List<Integer>> res = new ArrayList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        // track 中的元素会被标记为 true
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack(int[] nums,  boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择,nums[i] 已经在 track 中，跳过
            if (used[i]) {
                continue;
            }

            //做选择
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            //撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
