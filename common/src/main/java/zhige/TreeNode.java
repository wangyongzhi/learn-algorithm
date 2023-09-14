package zhige;

/**
 * 二叉树
 * @author wangyongzhi
 * @date 2023/9/13
 */
public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    /**
     * 打印二叉树
     * @param root
     */
    public static void print(TreeNode root) {
        printTree(root);
        System.out.println();
    }

    /**
     * 打印二叉树
     * @param root
     */
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }


    /**
     * 构建二叉树。
     * @param nums
     * @return
     */
    public static TreeNode build(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildHelper(nums, 0);
    }

    private static TreeNode buildHelper(int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }

        TreeNode root = new TreeNode(nums[index]);

        root.left = buildHelper(nums, 2 * index + 1);
        root.right = buildHelper(nums, 2 * index + 2);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = build(nums);

        // 打印构建好的二叉树
        printTree(root);
    }



}
