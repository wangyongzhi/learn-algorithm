package zhige;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyongzhi
 * @date 2023-02-20
 *
 * @see E1TwoSum
 * @see M1_nSum
 * @see M15_3Sum
 * @see M18_4Sum
 * @see M167TwoSumIiInputArrayIsSorted
 *
 */
public class M1_nSum {


    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums,4,0,target);
    }


    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sz = nums.length;

        if (n < 2 || sz < n) {
            return res;
        }

        if (nums[0] > target && nums[0] > 0) {
            return res;
        }

        if (nums[sz - 1] < target && nums[sz - 1] < 0) {
            return res;
        }

        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                long sum = (long)nums[left] + nums[right];
                int low = nums[left];
                int high = nums[right];
                if (sum > target) {
                    while (left < right && nums[right] == high){ right--;}

                } else if (sum < target) {
                    while (left < right && nums[left] == low) { left++;}
                }
                else {
                    res.add(Arrays.asList(nums[left], nums[right]));
                    while (left < right && nums[right] == high) { right--; }
                    while (left < right && nums[left] == low){ left++; }

                }
            }
        } else {
            for (int i = start; i < nums.length - n + 1; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(arr);
                    res.add(temp);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 2};
        ArrayUtils.print(nums);

        M1_nSum array = new M1_nSum();
        List<List<Integer>> r = array.fourSum(nums, 0);

        System.out.println(r);


    }

}
