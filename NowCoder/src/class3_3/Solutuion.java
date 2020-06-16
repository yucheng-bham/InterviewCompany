package class3_3;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/16 17:04
 */
class Solutuion_3 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
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


    class Result {
        TreeNode root;
        int min;
        int max;
        int sum;
    }

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        Result res = helper(root);
        return res == null ? 0 : res.sum;
    }

    public Result helper(TreeNode node) {
        if (node == null) return null;

        Result l = helper(node.left);
        Result r = helper(node.right);

        boolean lvalid = (l == null || l.root == node.left && l.max < node.val);
        boolean rvalid = (r == null || r.root == node.right && r.min > node.val);
        if (lvalid && rvalid) {
            Result res = new Result();
            res.root = node;
            res.min = (l == null ? node.val : l.min);
            res.max = (r == null ? node.val : r.max);
            res.sum = (l == null ? 0 : l.sum) + (r == null ? 0 : r.sum) + node.val;
            return res;
        }
        // now the node is not taken into consideration due to not BST
        if (l != null && r != null) {
            return l.sum > r.sum ? l : r;
        }
        if (l != null) return l;
        if (r != null) return r;
        return null;
    }

    public static TreeNode arrToTree(int[] arr, int i) {
        if (i >= arr.length) return new TreeNode();
        return new TreeNode(arr[i], arrToTree(arr, i + 1), arrToTree(arr, i + 2));
    }

    public static void main(String[] args) {
        Solutuion_3 solutuion_3 = new Solutuion_3();
        TreeNode root = arrToTree(new int[]{-4, -2, -5}, 0);
        int res = solutuion_3.maxSumBST(root);
        System.out.println(res);
    }


}
