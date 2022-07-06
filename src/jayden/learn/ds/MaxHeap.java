package jayden.learn.ds;

public class MaxHeap {

    int[] array;
    int length;

    public MaxHeap(int[] array) {
        this.length = array.length;
        this.array = new int[this.length];
        System.arraycopy(array, 0, this.array, 0, this.array.length);
        for (int i = parent(this.array.length - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    public int[] sort() {
        for (int i = 0; i < this.array.length; i++) {
            swap(0, this.array.length - 1 - i);
            this.length--;
            heapify(0);
        }
        return this.array;
    }

    private void heapify(int i) {
        if (left(i) != -1 && array[i] < array[left(i)]) {
            swap(i, left(i));
            heapify(left(i));
        }
        if (right(i) != -1 && array[i] < array[right(i)]) {
            swap(i, right(i));
            heapify(right(i));
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int parent(int i) {
        return i == 0 ? 0 : (i - 1) / 2;
    }

    private int left(int i) {
        int index = 2 * i + 1;
        return index >= this.length ? -1 : index;
    }

    private int right(int i) {
        int index = 2 * i + 2;
        return index >= this.length ? -1 : index;
    }
}
