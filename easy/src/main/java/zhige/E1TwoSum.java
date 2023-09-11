package zhige;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * https://leetcode.cn/problems/two-sum/
 *
 * @see E1TwoSum
 * @see M1_nSum
 * @see M15_3Sum
 * @see M18_4Sum
 * @see M167TwoSumIiInputArrayIsSorted
 *
 * @author wangyongzhi
 * @date 2023-02-19
 */
public class E1TwoSum {


    /**
     * 首先想到的肯定是拿第一个元素与后面的依次加，看是否等于目标值，
     * 然后再第二个、第三个...
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{0,0};
    }

    /**
     * 把数值作为 key，它的下标作为 value
     * 遍历数组，判断 map 是否含有这个目标值-当前数值，
     * 有直接返回，没有的话放到map里面
     *
     * 所以以后写代码，如果有双层 for 循环，首先考虑一下能否用 map 替换一层，空间换时间。
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums = {11,2,7,15};
        ArrayUtils.print(nums);

        E1TwoSum array = new E1TwoSum();
        int[] r = array.twoSum2(nums, 9);

        ArrayUtils.print(r);


    }
}
