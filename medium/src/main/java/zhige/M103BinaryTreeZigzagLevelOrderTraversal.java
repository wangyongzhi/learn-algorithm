package zhige;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 103. 二叉树的锯齿形层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @see M102BinaryTreeLevelOrderTraversal
 * @see M103BinaryTreeZigzagLevelOrderTraversal
 *
 * 与102的区别是：
 * 102只是从左往右，而103是先从左往右，再从右往左，所以需要一个标识用来切换方向。
 *
 *
 * @author wangyongzhi
 */
public class M103BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 广度优先用队列
     * 用while循环从上到下，for循环从左往右
     * 用一个标识isOrderLeft确定是从左往右还是从右往左。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isOrderLeft = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> levelRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (isOrderLeft) {
                    levelRes.addLast(cur.val);
                }else {
                    levelRes.addFirst(cur.val);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            isOrderLeft = !isOrderLeft;
            res.add(levelRes);
        }

        return res;

    }


    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = TreeNode.build(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.print(root);


        M103BinaryTreeZigzagLevelOrderTraversal clazz = new M103BinaryTreeZigzagLevelOrderTraversal();
        // 广度优先搜索遍历二叉树
        List<List<Integer>> lists = clazz.zigzagLevelOrder(root);

        System.out.println(lists);
    }
}
