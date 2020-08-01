/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/16 17:13
 */
public class Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode arrToTree(int[] arr, int i) {
        return new TreeNode(arr[i], arrToTree(arr, i + 1), arrToTree(arr, i + 2));
    }
}
