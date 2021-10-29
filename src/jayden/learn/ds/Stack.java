package jayden.learn.ds;

public class Stack {

    private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    private final LinkedList stack;
    private final int maxSize;
    private int size;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public Object peek() {
        return this.stack.checkHead();
    }

    public Object pop() {
        if (isEmpty()) {
            throw new Error("Stack is empty!");
        }
        Object data = this.stack.removeHead();
        this.size--;
        return data;
    }

    public void push(Object data) {
        if (!hasSpace()) {
            throw new Error("Stack is full!");
        }
        this.stack.addToHead(data);
        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("- " + this.size + "\n");
        Node node = stack.getHead();
        while (node != null) {
            sb.append(node.getData()).append("\n");
            node = node.getNext();
        }
        sb.append("---\n");
        return sb.toString();
    }
}
