package jayden.learn.ds;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public Object checkHead() {
        return this.head == null ? null : this.head.getData();
    }

    public boolean isExist(Object data) {
        return isExist(data, head);
    }

    private boolean isExist(Object data, Node node) {
        if (node == null) {
            return false;
        } else if (node.getData().equals(data)) {
            return true;
        } else {
            return isExist(data, node.getNext());
        }
    }

    public Object findMiddleAlt() {
        Node chaser = this.head, seeker = this.head;
        int count = 0;
        while (seeker != null) {
            seeker = seeker.getNext();
            if (count++ % 2 != 0) {
                chaser = chaser.getNext();
            }
        }
        return chaser == null ? null : chaser.getData();
    }

    public Object findMiddle() {
        Node chaser = this.head, seeker = this.head;
        while (seeker != null) {
            seeker = seeker.getNext();
            if (seeker != null) {
                chaser = chaser.getNext();
                seeker = seeker.getNext();
            }
        }
        return chaser == null ? null : chaser.getData();
    }

    public Object nthLastValue(int lastIndex) {
        Node chaser = null;
        Node seeker = this.head;
        int count = 0;
        while (seeker != null) {
            if (count >= lastIndex) {
                if (chaser == null) {
                    chaser = this.head;
                } else {
                    chaser = chaser.getNext();
                }
            }
            count++;
            seeker = seeker.getNext();
        }
        return chaser == null ? null : chaser.getData();
    }

    public void swap(Object data1, Object data2) {
        if (data1.equals(data2)) {
            return;
        }
        Node node1 = this.head, node2 = this.head;
        Node node1Pre = null, node2Pre = null;
        while (node1 != null) {
            if (node1.getData().equals(data1)) {
                break;
            }
            node1Pre = node1;
            node1 = node1.getNext();
        }
        while (node2 != null) {
            if (node2.getData().equals(data2)) {
                break;
            }
            node2Pre = node2;
            node2 = node2.getNext();
        }
        if (node1 == null || node2 == null) {
            System.out.println("Error: Cannot find one or more elements in the list!");
            return;
        }
        if (node1Pre == null) {
            this.head = node2;
        } else {
            node1Pre.setNext(node2);
        }
        if (node2Pre == null) {
            this.head = node1;
        } else {
            node2Pre.setNext(node1);
        }
        Node temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
    }

    public Object remove(Object data) {
        Node previousHead = null;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                if (previousHead == null) {
                    this.head = currentNode.getNext();
                } else {
                    previousHead.setNext(currentNode.getNext());
                }
                return currentNode.getData();
            }
            previousHead = currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void addToHead(Object data) {
        Node head = new Node(data);
        Node currentHead = this.head;
        this.head = head;
        this.head.setNext(currentHead);
    }

    public void addToTail(Object data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(new Node(data));
        }
    }

    public Object removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNext();
        return removedHead.getData();
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
