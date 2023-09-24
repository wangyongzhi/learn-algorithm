package zhige;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * @author wangyongzhi
 * @date 2023/9/24
 */
public class M215KthLargestElementInAnArray {

    /**
     * 方法1：用一个小顶堆，当堆长度大于k时，把最小的移除，最后最小的就是第k大的数。
     *
     * 堆的大小不会超过 k，所以插入和删除元素的复杂度是 O(logk)，再套一层 for 循环，
     *      假设数组元素总数为 N，总的时间复杂度就是 O(Nlogk)。
     * 这个解法的空间复杂度很显然就是二叉堆的大小，为 O(k)。
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    

    /**
     * 方法2：快速选择算法（Quick Select）。
     * 题目问「第 k 个最大的元素」，相当于数组升序排序后「排名第 n - k 的元素」
     *
     *
     */
    public int findKthLargest2(int[] nums, int k) {
        // 首先随机打乱数组
        shuffle(nums);
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // 转化成「排名第 k 的元素」
        k = n - k;
        while (lo <= hi) {
            // 在 nums[lo..hi] 中选一个分界点
            int p = partition(nums, lo, hi);
            if (p < k) {
                // 第 k 大的元素在 nums[p+1..hi] 中
                lo = p + 1;
            } else if (p > k) {
                // 第 k 大的元素在 nums[lo..p-1] 中
                hi = p - 1;
            } else {
                // 找到第 k 大元素
                return nums[p];
            }
        }
        return -1;
    }

    // 对 nums[lo..hi] 进行切分
    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, lo, j);
        return j;
    }

    // 洗牌算法，将输入的数组随机打乱
    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
