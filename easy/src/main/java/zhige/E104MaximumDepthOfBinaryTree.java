package zhige;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @see E104MaximumDepthOfBinaryTree
 * @see E111MinimumDepthOfBinaryTree
 * @see E543DiameterOfBinaryTree
 *
 * @author wangyongzhi
 * @date 2023/9/13
 */
public class E104MaximumDepthOfBinaryTree {

    /**
     * 方法二：
     * 可以算出当前节点的子节点的最大深度，最后加1即可。
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);

        return Math.max(maxLeft, maxRight) + 1;

    }


    int result = 0,  depth = 0;

    /**
     * 方法一：
     * 定义一个记录最终深度的变量 result，和一个记录当前深度的变量depth。
     * 由于二叉树的遍历过程中，先序的地方是进入节点的时候，后序是出节点的时候，则记录当前深度的depth，先序的时候++，后序的时候--即可。
     * 先序的时候还要判断一下如果是叶子节点，比较最大结果与当前结果的值，result取最大的。
     */
    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;

        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            result = Math.max(result, depth);
        }

        traverse(root.left);
        traverse(root.right);

        depth--;

    }


}
