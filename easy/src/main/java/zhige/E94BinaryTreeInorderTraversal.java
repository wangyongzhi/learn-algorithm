package zhige;

import java.util.ArrayList;
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

}
