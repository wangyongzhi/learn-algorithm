package radishdata.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 * @author wangyongzhi
 * @date 2023-02-19
 */
public class M15_3Sum {


    public List<List<Integer>> threeSum(int[] nums) {

        // 求和为 0 的三元组
        return threeSumTarget(nums, 0);
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);

        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // 穷举 threeSum 的第一个数
        for (int i = 0; i < length; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }

        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {

        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }

            } else if (sum > target) {
                while (lo < hi && nums[hi] == right){
                    hi--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right){
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ArrayUtils.print(nums);

        M15_3Sum array = new M15_3Sum();
        List<List<Integer>>  r = array.threeSum(nums);

        System.out.println(r);


    }
}
