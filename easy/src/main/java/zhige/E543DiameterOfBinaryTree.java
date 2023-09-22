package zhige;

/**
 *
 * 543. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 *
 * @see E104MaximumDepthOfBinaryTree 二叉树的最大深度
 * @see E111MinimumDepthOfBinaryTree 二叉树的最小深度
 * @see E543DiameterOfBinaryTree 二叉树的直径
 *
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class E543DiameterOfBinaryTree {

    // 记录最大直径的长度
    int maxDiameter = 0;

    /**
     * 本质上是找到每个节点的最大深度之和
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    /**
     * 最大深度为左右深度的最大值+1
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        //最大直径，取左右深度之和与之前值的更大值。
        maxDiameter = Math.max(maxDiameter, maxLeft + maxRight);

        //最大深度为左右子树深度最大值+1
        return Math.max(maxLeft, maxRight) + 1;

    }
}
