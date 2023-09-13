package zhige;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * @author wangyongzhi
 * @date 2023/9/13
 */
public class E144BinaryTreePreorderTraversal {

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        return res;

    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);

    }
}
