package jayden.learn.ds;

public class Tree {

    private final TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public int maxDepth() {
        return maxDepth(this.root);
    }

    private int maxDepth(TreeNode node) {
        int maxDepth = 0;
        for (TreeNode child : node.getChildren()) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }

    public void breadthFirstTraversal() {
        TreeNode current = this.root;
        Queue queue = new Queue();
        queue.enqueue(current);
        while (queue.isNotEmpty()) {
            current = (TreeNode) queue.dequeue();
            System.out.print(current.getData() + " ");
            for (TreeNode child : current.getChildren()) {
                queue.enqueue(child);
            }
        }
    }

    public void depthFirstTraversal(TreeNode node) {
        System.out.print(node.getData() + " ");
        for (TreeNode child : node.getChildren()) {
            depthFirstTraversal(child);
        }
    }

    public void printAt(int level) {
        printAt(1, level, this.root);
    }

    private void printAt(int level, int targetLevel, TreeNode node) {
        if (level < targetLevel - 1) {
            for (TreeNode child : node.getChildren()) {
                printAt(level + 1, targetLevel, child);
            }
        } else if (level == targetLevel - 1) {
            for (TreeNode child : node.getChildren()) {
                System.out.print(child.getData() + " ");
            }
        } else if (level == targetLevel) {
            System.out.print(node.getData());
        }
    }

    public void print() {
        print(1, this.root);
    }

    private void print(int level, TreeNode node) {
        System.out.println("-- ".repeat(Math.max(0, level - 1)) + node.getData().toString());
        for (TreeNode child : node.getChildren()) {
            print(level + 1, child);
        }
    }
}
