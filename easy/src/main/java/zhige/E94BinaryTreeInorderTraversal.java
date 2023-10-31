package zhige;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
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
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class E94BinaryTreeInorderTraversal {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        traverse(root);
        return res;

    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);

    }



    /**
     * 方法二：不用定义另外一个函数解决。
     * addAll 方法的复杂度都是 O(N)，所以总体的最坏时间复杂度会达到 O(N^2)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }

        res.addAll(inorderTraversal2(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal2(root.right));

        return res;
    }


}
