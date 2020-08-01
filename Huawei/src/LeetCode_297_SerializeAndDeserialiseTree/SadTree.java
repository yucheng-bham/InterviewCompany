package LeetCode_297_SerializeAndDeserialiseTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/25 12:08
 */
public class SadTree {
    public static void main(String[] args) {
        Codec codec = new Codec();
        Integer[] arr = {1,2,3,null, null, 4, 5};
        TreeNode root = buildTreeNode(arr, 0);
        TreeNode treeNode = codec.deserialize(codec.serialize(root));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node != null) {
                System.out.println(node.val);
                q.add(node.left);
                q.add(node.right);
            } else {
                System.out.println("null");
            }
        }
    }

    private static TreeNode buildTreeNode(Integer[] arr, int index) {
        if (index > arr.length || arr[index] == null) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = buildTreeNode(arr, index * 2 + 1);
        root.right = buildTreeNode(arr, index * 2 + 2);
        return root;
    }
}
/**
 * Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Codec {
    private static final String N = "x";
    private static final String spl = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(N).append(spl);
        } else {
            sb.append(node.val).append(spl);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spl)));
        return buildTree(q);
    }
    private TreeNode buildTree(Deque<String> q) {
        String val = q.remove();
        if (val.equals(N)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
