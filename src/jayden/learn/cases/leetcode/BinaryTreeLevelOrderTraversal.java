package jayden.learn.cases.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Example 1

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]


Example 2

Input: root = [1]
Output: [[1]]


Example 3

Input: root = []
Output: []
*/
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        {
            TreeNode n15 = new TreeNode(15, null, null);
            TreeNode n7 = new TreeNode(7, null, null);
            TreeNode n20 = new TreeNode(20, n15, n7);
            TreeNode n9 = new TreeNode(9, null, null);
            TreeNode n3 = new TreeNode(3, n9, n20);
            BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
            if ("[[3], [9, 20], [15, 7]]".equals(solution.levelOrder(n3).toString())) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            TreeNode n1 = new TreeNode(1, null, null);
            BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
            if ("[[1]]".equals(solution.levelOrder(n1).toString())) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
        {
            BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
            if ("[]".equals(solution.levelOrder(null).toString())) {
                System.out.println("Testcase 3: passed");
            } else {
                System.err.println("Testcase 3: failed");
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            view(list, queue);
        }
        return list;
    }

    private static void view(List<List<Integer>> list, Queue<TreeNode> queue) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>(size);
        while (!queue.isEmpty() && (size-- > 0)) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        list.add(level);
        if (!queue.isEmpty()) {
            view(list, queue);
        }
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
