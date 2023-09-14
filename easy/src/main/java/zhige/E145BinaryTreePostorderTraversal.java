package zhige;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 145. 二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 *
 * @see E144BinaryTreePreorderTraversal 二叉树的先序遍历
 * @see E94BinaryTreeInorderTraversal 二叉树的中序遍历
 * @see E145BinaryTreePostorderTraversal 二叉树的后序遍历
 *
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class E145BinaryTreePostorderTraversal {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        traverse(root);
        return res;

    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        res.add(root.val);

    }
}
