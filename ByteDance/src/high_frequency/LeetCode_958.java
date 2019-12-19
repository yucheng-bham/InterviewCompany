package high_frequency;

import StructureLeetCode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_958 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
       /* 这是我自己实现的medium面试题目，虽然花费了我3h45min。可是，我觉得是值得的。因为这是自信心的提升。
       *  可以我同时要承认的是，这个bfs算法，代码不够简洁。实现的不好，我应该学习成熟的代码。
       * */
        /*public boolean isCompleteTree(TreeNode root) {
            Deque<TreeNode> nextq = new ArrayDeque<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int level = 1;
            while (!q.isEmpty()) {
                int levelsize = q.size();

                while (levelsize-- > 0) {
                    TreeNode node = q.poll();
//                    nextq.clear();
                    if (node != null) {
                        if (node.left != null) nextq.offer(node.left);
                        if (node.right != null) nextq.offer(node.right);
                        q.offer(node.left);
                        q.offer(node.right);
                    } else {
                        if (!nextq.isEmpty()) {
                            return false;
                        } else {
                            while (levelsize-- != 0) {
                                TreeNode nextNull = q.poll();
                                if (nextNull != null) return false;
                            }
                        }
                    }

                }
                nextq.clear();
            }
            return true;
        }*/
        // bfs

        //dfs
        private int count;
        public boolean isCompleteTree(TreeNode root) {
            if(root == null) {
                return true;
            }
            count = 0;
            int expected = dfs(root,1);
            return count == expected;
        }
        private int dfs(TreeNode root, int level) {
            if (root == null) {
                return 0;
            }
            count++;
            return Math.max(level,
                    Math.max(dfs(root.left, level *2), dfs(root.right, level * 2 + 1)));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,null,7]");
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6]");
        System.out.println(sol.isCompleteTree(root));
    }
}
