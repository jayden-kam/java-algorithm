package jayden.learn.ds;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Object removeFromHead(Object data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if (nodeToRemove == null) {
            return null;
        }
        if (this.head == nodeToRemove) {
            removeHead();
        } else if (this.tail == nodeToRemove) {
            removeTail();
        } else {
            Node previousNode = nodeToRemove.getPrevious();
            Node nextNode = nodeToRemove.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }
        return nodeToRemove.getData();
    }

    public Object removeTail() {
        Node removedTail = this.tail;
        if (removedTail == null) {
            return null;
        }
        this.tail = removedTail.getPrevious();
        if (this.tail != null) {
            this.tail.setNext(null);
        }
        if (this.head == removedTail) {
            removeHead();
        }
        return removedTail.getData();
    }

    public Object removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNext();
        if (this.head != null) {
            this.head.setPrevious(null);
        }
        if (this.tail == removedHead) {
            removeTail();
        }
        return removedHead.getData();
    }

    public void addToTail(Object data) {
        Node tail = new Node(data);
        Node currentTail = this.tail;
        if (currentTail != null) {
            currentTail.setNext(tail);
            tail.setPrevious(currentTail);
        }
        this.tail = tail;
        if (this.head == null) {
            this.head = tail;
        }
    }

    public void addToHead(Object data) {
        Node head = new Node(data);
        Node currentHead = this.head;
        if (currentHead != null) {
            currentHead.setPrevious(head);
            head.setNext(currentHead);
        }
        this.head = head;
        if (this.tail == null) {
            this.tail = head;
        }
    }

    public String printList() {
        StringBuilder output = new StringBuilder("<head> ");
        Node currentNode = this.head;
        while (currentNode != null) {
            output.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNext();
        }
        output.append("<tail>");
        System.out.println(output);
        return output.toString();
    }
}
