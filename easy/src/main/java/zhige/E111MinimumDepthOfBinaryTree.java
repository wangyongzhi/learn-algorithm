package zhige;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 *
 * @see E104MaximumDepthOfBinaryTree 二叉树的最大深度
 * @see E111MinimumDepthOfBinaryTree 二叉树的最小深度
 * @see E543DiameterOfBinaryTree 二叉树的直径
 *
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class E111MinimumDepthOfBinaryTree {

    /**
     * 方法一：拿到所有子树的最低高度，最后加1就是总的最低高度。
     *
     * 最小深度。取左边最小深度和右边最小深度，比较之后的最小值再加1即可。
     * 不过要防止左子树或者右子树为空的情况。这时候要取最大值。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        //左右其中一个为0，那取不为0的，再加1。
        if (minLeft == 0 || minRight == 0) {
            return Math.max(minLeft, minRight) + 1;
        }

        //左右都为0，或者左右都不为0，取最小值+1即可。
        return Math.min(minLeft, minRight) + 1;

    }


    /**
     * 方法二：使用 BFS 按层遍历，找到第一个左右都为空的子节点，返回它的深度即可。速度更快。
     * BFS需要队列。
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //从1开始，其实是加了根节点。
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;

    }
}
