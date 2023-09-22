package zhige;

import java.util.Arrays;

/**
 *
 * 88. 合并两个有序数组
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 *  其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * https://leetcode.cn/problems/merge-sorted-array/description/
 *
 * @author wangyongzhi
 * @date 2023/9/19
 */
public class E88MergeSortedArray {


    /**
     * 方法3：由于num1 后面是空的，所以可以通过逆向的方式，先放最大的值在后面，倒序去排。这样额外空间复杂度为O(1)
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                //如果p1都排完了，则把num2所有的放在最终数组里面。反之亦然
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                //如果p1小于p2的值，则先放p2
                cur = nums2[p2--];
            }else {
                cur = nums1[p1--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 方法2：用一个临时数组存储最终数据，双指针遍历两个数组。时间复杂度O（m+n），额外空间复杂度O（m+n）
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];
        int p1 = 0, p2 = 0;

        int cur = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                //如果p1都排完了，则把num2所有的放在最终数组里面。反之亦然
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                //如果p1小于p2的值，则先放p1
                cur = nums1[p1++];
            }else {
                cur = nums2[p2++];
            }
            res[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < m+n; i++) {
            nums1[i] = res[i];
        }
    }


    /**
     * 方法1：直接合并两个数字，做排序即可。时间复杂度O((m+n) log (m+n))，空间复杂度O( log (m+n))
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


}
