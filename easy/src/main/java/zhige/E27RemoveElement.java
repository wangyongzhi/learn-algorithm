package zhige;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * https://leetcode.cn/problems/remove-element/
 *
 * @see E26RemoveDuplicatesFromSortedArray
 * @see E283MoveZeroes
 *
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E27RemoveElement {

    /**
     * 快慢指针，判断fast是否与val相同，如果不相同，则赋值给slow
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //slow是赋值之后++的，现在已经是最终数组长度了，不用再加一了。
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 3};

        E27RemoveElement array = new E27RemoveElement();
        int i = array.removeElement(nums, 3);
        System.out.println(i);

    }
}
