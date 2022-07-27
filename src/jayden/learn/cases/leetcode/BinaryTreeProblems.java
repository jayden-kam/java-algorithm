package jayden.learn.cases.leetcode;

import java.util.*;

public class BinaryTreeProblems {

    public static void main(String[] args) {
        testFlattenBinaryTreeToLinkedList();
        testBinaryTreeRightSideView();
        testBinaryTreeLevelOrderTraversal();
        testConstructBinaryTreeFromPreorderAndInorderTraversal();
    }

    public static void testFlattenBinaryTreeToLinkedList() {
        BinaryTreeProblems solution = new BinaryTreeProblems();
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, n2, n5);
        solution.flatten(n1);
    }

    public static void testConstructBinaryTreeFromPreorderAndInorderTraversal() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTreeProblems solution = new BinaryTreeProblems();
        TreeNode node = solution.buildTree(preorder, inorder);
        System.out.println(node);
    }

    public static void testBinaryTreeLevelOrderTraversal() {
        {
            TreeNode n15 = new TreeNode(15, null, null);
            TreeNode n7 = new TreeNode(7, null, null);
            TreeNode n20 = new TreeNode(20, n15, n7);
            TreeNode n9 = new TreeNode(9, null, null);
            TreeNode n3 = new TreeNode(3, n9, n20);
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[[3], [9, 20], [15, 7]]".equals(solution.levelOrder(n3).toString())) {
                System.out.println("BinaryTreeLevelOrderTraversal testcase 1: passed");
            } else {
                System.err.println("BinaryTreeLevelOrderTraversal testcase 1: failed");
            }
        }
        {
            TreeNode n1 = new TreeNode(1, null, null);
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[[1]]".equals(solution.levelOrder(n1).toString())) {
                System.out.println("BinaryTreeLevelOrderTraversal testcase 2: passed");
            } else {
                System.err.println("BinaryTreeLevelOrderTraversal testcase 2: failed");
            }
        }
        {
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[]".equals(solution.levelOrder(null).toString())) {
                System.out.println("BinaryTreeLevelOrderTraversal testcase 3: passed");
            } else {
                System.err.println("BinaryTreeLevelOrderTraversal testcase 3: failed");
            }
        }
    }

    public static void testBinaryTreeRightSideView() {
        {
            TreeNode n8 = new TreeNode(8, null, null);
            TreeNode n7 = new TreeNode(7, n8, null);
            TreeNode n6 = new TreeNode(6, null, null);
            TreeNode n5 = new TreeNode(5, n6, n7);
            TreeNode n4 = new TreeNode(4, null, null);
            TreeNode n3 = new TreeNode(3, null, n4);
            TreeNode n2 = new TreeNode(2, null, n5);
            TreeNode n1 = new TreeNode(1, n2, n3);
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[1, 3, 4, 7, 8]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("BinaryTreeRightSideView testcase 1: passed");
            } else {
                System.err.println("BinaryTreeRightSideView testcase 1: failed");
            }
        }
        {
            TreeNode n5 = new TreeNode(5, null, null);
            TreeNode n4 = new TreeNode(4, null, null);
            TreeNode n3 = new TreeNode(3, null, n4);
            TreeNode n2 = new TreeNode(2, null, n5);
            TreeNode n1 = new TreeNode(1, n2, n3);
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[1, 3, 4]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("BinaryTreeRightSideView testcase 2: passed");
            } else {
                System.err.println("BinaryTreeRightSideView testcase 2: failed");
            }
        }
        {
            TreeNode n3 = new TreeNode(3, null, null);
            TreeNode n1 = new TreeNode(1, null, n3);
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[1, 3]".equals(solution.rightSideView(n1).toString())) {
                System.out.println("BinaryTreeRightSideView testcase 3: passed");
            } else {
                System.err.println("BinaryTreeRightSideView testcase 3: failed");
            }
        }
        {
            BinaryTreeProblems solution = new BinaryTreeProblems();
            if ("[]".equals(solution.rightSideView(null).toString())) {
                System.out.println("BinaryTreeRightSideView testcase 4: passed");
            } else {
                System.err.println("BinaryTreeRightSideView testcase 4: failed");
            }
        }
    }

    /*
    Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right
     child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.
    */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flat(root);
    }

    private TreeNode flat(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode leftTail = null, rightTail = null;
        if (node.left != null) {
            leftTail = flat(node.left);
        }
        if (node.right != null) {
            rightTail = flat(node.right);
        }
        if (leftTail != null) {
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            leftTail.right = temp;
        }
        return rightTail == null ? leftTail : rightTail;
    }

    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia:
        “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that
         has both p and q as descendants (where we allow a node to be a descendant of itself).”
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    /*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal
        of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


    Example 1:
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        } else if (preorder.length == 0) {
            throw new Error("Bad Input");
        } else if (inorder.length == 0) {
            throw new Error("Bad Input");
        }
        int topVal = preorder[0];
        TreeNode top = new TreeNode(topVal);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == topVal) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new Error("Bad Input");
        }
        TreeNode left = buildTree(
                Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index)
        );
        TreeNode right = buildTree(
                Arrays.copyOfRange(preorder, 1 + index, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length)
        );
        top.left = left;
        top.right = right;
        return top;
    }

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            levelOrderView(list, queue);
        }
        return list;
    }

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

    public void levelOrderView(List<List<Integer>> list, Queue<TreeNode> queue) {
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
            levelOrderView(list, queue);
        }
    }

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
}
