package jayden.learn.ds;

import java.util.ArrayList;

public class TreeNode {

    private final Object data;
    private final ArrayList<TreeNode> children;
    private TreeNode parent;

    public TreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void removeChild(Object data) {
        for (TreeNode child : this.children) {
            if (child.getData().equals(data)) {
                this.children.remove(child);
                return;
            }
        }
        for (TreeNode child : this.children) {
            child.removeChild(data);
        }
    }

    public void removeChild(TreeNode node) {
        if (this.children.contains(node)) {
            this.children.remove(node);
        } else {
            for (TreeNode child : this.children) {
                child.removeChild(node);
            }
        }
    }

    public void addChild(Object data) {
        this.children.add(new TreeNode(data));
    }

    public void addChild(TreeNode node) {
        this.children.add(node);
    }

    public Object getData() {
        return this.data;
    }

    public ArrayList<TreeNode> getChildren() {
        return this.children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
