package zhige;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * https://leetcode.cn/problems/move-zeroes/
 * @author wangyongzhi
 * @date 2023-02-19
 * @see E27RemoveElement
 */
public class E283MoveZeroes {

    /**
     * 移动0，其实相当于先把0都删除掉，然后再在后面补上0
     * 可以参考 {@linkplain E27RemoveElement}
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = removeElement(nums, 0);
        for (;n<nums.length; n++) {
            nums[n] = 0;
        }

    }

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
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 4, 3};

        E283MoveZeroes array = new E283MoveZeroes();
        array.moveZeroes(nums);
        ArrayUtils.print(nums);

    }
}
