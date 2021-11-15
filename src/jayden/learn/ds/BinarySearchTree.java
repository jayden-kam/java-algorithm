package jayden.learn.ds;

public class BinarySearchTree {

    private int value;
    private int level;
    private BinarySearchTree left;
    private BinarySearchTree right;

    private BinarySearchTree(int value, int level) {
        this.value = value;
        this.level = level;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree(int value) {
        this(value, 1);
    }

    public void print() {
        if (this.right != null) {
            this.right.print();
        }
        System.out.println("\t".repeat(this.level - 1) + (this.level == 1 ? "" : "->") + this.value);
        if (this.left != null) {
            this.left.print();
        }
    }

    public void depthFirstTraversal() {
        if (this.left != null) {
            this.left.depthFirstTraversal();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.depthFirstTraversal();
        }
    }

    public BinarySearchTree retrieve(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.retrieve(value);
        } else if (value > this.value && this.right != null) {
            return this.right.retrieve(value);
        }
        return null;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new BinarySearchTree(value, this.level + 1);
            } else {
                this.left.insert(value);
            }
        } else if (value > this.value) {
            if (this.right == null) {
                this.right = new BinarySearchTree(value, this.level + 1);
            } else {
                this.right.insert(value);
            }
        }
    }
}
