package jayden.learn.ds;

import java.util.ArrayList;

public class MinHeap {

    private final ArrayList<Integer> heap;
    private int size;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(null);
        this.size = 0;
    }

    public int pop() {
        if (this.size == 0) {
            throw new Error("Heap is empty!");
        }
        System.out.println("Swap min element " + this.heap.get(1) + " and last element " + this.heap.get(this.size));
        this.swap(1, this.size);
        int minValue = this.heap.remove(this.size--);
        System.out.println("Removed from the heap: " + minValue);
        System.out.println(this);
        this.heapify();
        return minValue;
    }

    private void heapify() {
        int index = 1, leftChildIndex = this.getLeftChildIndex(index), rightChildIndex = this.getRightChildIndex(index);
        while (this.canSwap(index, leftChildIndex, rightChildIndex)) {
            if (this.exists(leftChildIndex) && this.exists(rightChildIndex)) {
                if (this.heap.get(leftChildIndex) < this.heap.get(rightChildIndex)) {
                    this.swap(index, leftChildIndex);
                    index = leftChildIndex;
                } else {
                    this.swap(index, rightChildIndex);
                    index = rightChildIndex;
                }
            } else {
                this.swap(index, leftChildIndex);
                index = leftChildIndex;
            }
            leftChildIndex = this.getLeftChildIndex(index);
            rightChildIndex = this.getRightChildIndex(index);
        }
    }

    private boolean canSwap(int index, int leftChildIndex, int rightChildIndex) {
        return (this.exists(leftChildIndex) && this.heap.get(leftChildIndex) < this.heap.get(index)) ||
                (this.exists(rightChildIndex) && this.heap.get(rightChildIndex) < this.heap.get(index));
    }

    private boolean exists(int index) {
        return index <= this.size;
    }

    public void add(int value) {
        this.heap.add(value);
        this.size++;
        System.out.println(this);
        this.bubbleUp();
    }

    private void bubbleUp() {
        int index = this.size;
        while (index > 1 && this.heap.get(index) < this.heap.get(this.getParentIndex(index))) {
            this.swap(index, this.getParentIndex(index));
            index = this.getParentIndex(index);
        }
    }

    private void swap(int index1, int index2) {
        System.out.println("Swap index " + index1 + " with index " + index2);
        int temp = this.heap.get(index2);
        this.heap.set(index2, this.heap.get(index1));
        this.heap.set(index1, temp);
        System.out.println(this);
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    @Override
    public String toString() {
        this.heap.remove(0);
        String content = this.heap.toString();
        this.heap.add(0, null);
        return content;
    }
}
