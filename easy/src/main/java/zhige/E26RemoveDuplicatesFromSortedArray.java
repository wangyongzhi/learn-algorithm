package zhige;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }

        // 数组长度为索引 + 1
        return slow + 1;

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4};

        E26RemoveDuplicatesFromSortedArray array = new E26RemoveDuplicatesFromSortedArray();
        int i = array.removeDuplicates(nums);
        System.out.println(i);

    }
}
