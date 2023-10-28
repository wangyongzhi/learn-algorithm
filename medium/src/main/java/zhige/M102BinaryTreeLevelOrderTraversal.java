package zhige;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * @see M102BinaryTreeLevelOrderTraversal
 * @see M103BinaryTreeZigzagLevelOrderTraversal
 *
 * @author wangyongzhi
 * @date 2023/9/14
 */
public class M102BinaryTreeLevelOrderTraversal {

    /**
     * 本质是广度优先遍历，广度优先用队列。
     * while循环代表每一层，从上到下
     * for代表一层从左到右。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                levelRes.add(cur.val);
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(levelRes);
        }

        return res;

    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = TreeNode.build(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.print(root);


        M102BinaryTreeLevelOrderTraversal clazz = new M102BinaryTreeLevelOrderTraversal();
        // 广度优先搜索遍历二叉树
        List<List<Integer>> lists = clazz.levelOrder(root);

        System.out.println(lists);
    }
}
