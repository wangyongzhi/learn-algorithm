package zhige;

/**
 * 124. 二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 *
 * @see E144BinaryTreePreorderTraversal 二叉树的先序遍历
 * @see E94BinaryTreeInorderTraversal 二叉树的中序遍历
 * @see E145BinaryTreePostorderTraversal 二叉树的后序遍历
 *
 * @see E104MaximumDepthOfBinaryTree 二叉树的最大深度
 * @see E111MinimumDepthOfBinaryTree 二叉树的最小深度
 * @see E543DiameterOfBinaryTree 二叉树的直径
 *
 * @see M102BinaryTreeLevelOrderTraversal 二叉树的层序遍历
 * @see M103BinaryTreeZigzagLevelOrderTraversal 二叉树的锯齿形层序遍历
 *
 * @see M236LowestCommonAncestorOfABinaryTree 二叉树的最近公共祖先
 * @see H124BinaryTreeMaximumPathSum 二叉树最大路径和
 *
 *
 * @author wangyongzhi
 * @date 2023/10/28
 */
public class H124BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);

        int sum = root.val + left + right;

        //更新答案
        maxSum = Math.max(sum, maxSum);

        // 返回节点的最大贡献值，左边和右边取最大值。
        return root.val + Math.max(left, right);
    }


    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = TreeNode.build(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.print(root);


        H124BinaryTreeMaximumPathSum clazz = new H124BinaryTreeMaximumPathSum();
        int i = clazz.maxPathSum(root);

        System.out.println(i);
    }
}
