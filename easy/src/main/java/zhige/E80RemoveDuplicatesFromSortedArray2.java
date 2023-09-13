package zhige;

/**
 *
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * @see E26RemoveDuplicatesFromSortedArray
 * @see E80RemoveDuplicatesFromSortedArray2
 * @see E27RemoveElement
 *
 *
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E80RemoveDuplicatesFromSortedArray2 {

    /**
     */
    public int removeDuplicates(int[] nums) {

        return 0;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4};

        E80RemoveDuplicatesFromSortedArray2 array = new E80RemoveDuplicatesFromSortedArray2();
        int i = array.removeDuplicates(nums);
        System.out.println(i);

    }
}
