package jayden.learn.ds;

public class Queue {

    private final LinkedList queue;
    private final int maxSize;
    private int size;

    public Queue() {
        this(Integer.MAX_VALUE);
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList();
        this.size = 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.queue.checkHead();
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new Error("Queue is empty!");
        }
        Object data = this.queue.removeHead();
        int sizeNow = --this.size;
        //System.out.println("Removed [" + data + "] Queue size is now " + sizeNow);
        return data;
    }

    public void enqueue(Object data) {
        if (!hasSpace()) {
            throw new Error("Queue is full!");
        }
        this.queue.addToTail(data);
        int sizeNow = ++this.size;
        //System.out.println("Added [" + data + "] Queue size is now " + sizeNow);
    }

    public int getSize() {
        return size;
    }
}
