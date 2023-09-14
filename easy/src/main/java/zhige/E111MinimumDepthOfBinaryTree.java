package zhige;

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
 * @see E104MaximumDepthOfBinaryTree
 * @see E111MinimumDepthOfBinaryTree
 *
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class E111MinimumDepthOfBinaryTree {

    /**
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
}
