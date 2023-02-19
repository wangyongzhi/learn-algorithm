package radishdata.top;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 * @author wangyongzhi
 * @date 2023-02-19
 * @see E27RemoveElement
 */
public class E283MoveZeroes {

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

        System.out.println("");

    }
}
