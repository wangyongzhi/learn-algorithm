package radishdata.top;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
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


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        ArrayUtils.print(nums);

        M167TwoSumIiInputArrayIsSorted array = new M167TwoSumIiInputArrayIsSorted();
        int[] r = array.twoSum(nums, 9);

        ArrayUtils.print(r);


    }
}
