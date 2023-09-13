package zhige;

/**
 * 26. 删除有序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * @see E26RemoveDuplicatesFromSortedArray
 * @see E80RemoveDuplicatesFromSortedArray2
 * @see E27RemoveElement
 *
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E26RemoveDuplicatesFromSortedArray {

    /**
     * 注意是原地删除，不能新创建数组。
     * 利用快慢指针，快指针探路，发现不一样的，把slow改成那个值，然后往右移动，快指针移动到最后返回慢指针的位置+1
     */
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
