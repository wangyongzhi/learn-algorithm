package zhige;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E27RemoveElement {

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
        int[] nums = {1, 1, 2, 3, 4, 3};

        E27RemoveElement array = new E27RemoveElement();
        int i = array.removeElement(nums, 3);
        System.out.println(i);

    }
}
