package DynamicProgramming;

import java.util.*;

class TreeNode {
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

public class UniqueBinarySearchTrees {
    public static List<TreeNode> solver(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            return new ArrayList<>(null);
        }
        if (start == end) {
            TreeNode root = new TreeNode(start);
            list.add(root);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = solver(start, i - 1);
            List<TreeNode> right = solver(i + 1, end);
            for (TreeNode root_left : left) {
                for (TreeNode root_right : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = root_left;
                    root.right = root_right;
                    list.add(root);
                }
            }
        }
        return list;

    }

    public List<TreeNode> generateTrees(int n) {
        return solver(1, n);

    }
}