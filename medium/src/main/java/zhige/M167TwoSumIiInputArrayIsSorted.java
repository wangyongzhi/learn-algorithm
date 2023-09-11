package zhige;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
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
public class M167TwoSumIiInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {

        // 一左一右两个指针相向而行
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }


    /**
     * 也可以跟第一题一样，直接相加判断。
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i< nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{0,0};
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        ArrayUtils.print(nums);

        M167TwoSumIiInputArrayIsSorted array = new M167TwoSumIiInputArrayIsSorted();
        int[] r = array.twoSum(nums, 9);

        ArrayUtils.print(r);


    }
}
