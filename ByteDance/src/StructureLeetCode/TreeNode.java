package StructureLeetCode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode createTestData(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        int len = split.length;
        TreeNode[] TreeNodes = new TreeNode[len];
//        data = data.substring(1, data.length() - 1);
        for (int i = 0; i < len; i++) {
            if (!split[i].equals("null"))
            TreeNodes[i] = new TreeNode(Integer.parseInt(split[i]));
        }

        for (int i = 0; i < len; i++) {
            if (TreeNodes[i] != null) {
                int leftIndex = i * 2 + 1;
                if (leftIndex < len) {
                    TreeNodes[i].left = TreeNodes[leftIndex];
                }
                int rightIndex = leftIndex + 1;
                if (rightIndex < len) {
                    TreeNodes[i].right = TreeNodes[rightIndex];
                }
            }
        }

        return TreeNodes[0];
    }


}

