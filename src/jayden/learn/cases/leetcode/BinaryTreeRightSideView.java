package jayden.learn.cases.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.


Example 1

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]


Example 2

Input: root = [1,null,3]
Output: [1,3]


Example 3

Input: root = []
Output: []
*/
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        {
            TreeNode n8 = new TreeNode(8, null, null);
            TreeNode n7 = new TreeNode(7, n8, null);
            TreeNode n6 = new TreeNode(6, null, null);
            TreeNode n5 = new TreeNode(5, n6, n7);
            TreeNode n4 = new TreeNode(4, null, null);
            TreeNode n3 = new TreeNode(3, null, n4);
            TreeNode n2 = new TreeNode(2, null, n5);
            TreeNode n1 = new TreeNode(1, n2, n3);
            BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
            if ("[1, 3, 4, 7, 8]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            TreeNode n5 = new TreeNode(5, null, null);
            TreeNode n4 = new TreeNode(4, null, null);
            TreeNode n3 = new TreeNode(3, null, n4);
            TreeNode n2 = new TreeNode(2, null, n5);
            TreeNode n1 = new TreeNode(1, n2, n3);
            BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
            if ("[1, 3, 4]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
        {
            TreeNode n3 = new TreeNode(3, null, null);
            TreeNode n1 = new TreeNode(1, null, n3);
            BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
            if ("[1, 3]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("Testcase 3: passed");
            } else {
                System.err.println("Testcase 3: failed");
            }
        }
        {
            BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
            if ("[]".equals(solution.rightSideView(null).toString())) {
                System.out.println("Testcase 4: passed");
            } else {
                System.err.println("Testcase 4: failed");
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            view(list, root, 0, -1);
        }
        return list;
    }

    private int view(List<Integer> list, TreeNode node, int depth, int rightMostDepth) {
        if (depth > rightMostDepth) {
            list.add(node.val);
            rightMostDepth = depth;
        }
        if (node.right != null) {
            rightMostDepth = view(list, node.right, depth + 1, rightMostDepth);
        }
        if (node.left != null) {
            rightMostDepth = view(list, node.left, depth + 1, rightMostDepth);
        }
        return rightMostDepth;
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
