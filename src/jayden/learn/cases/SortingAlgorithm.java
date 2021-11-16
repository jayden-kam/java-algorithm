package jayden.learn.cases;

import java.util.Arrays;

public class SortingAlgorithm {

    public static int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            if (start < partition) {
                quickSort(arr, start, partition);
            }
            if (partition + 1 < end) {
                quickSort(arr, partition + 1, end);
            }
        }
        return arr;
    }

    private static int partition(int[] arr, int leftPos, int rightPos) {
        System.out.println("Partitioning the current subarray:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, leftPos, rightPos + 1)));
        int pivot = arr[(leftPos + rightPos) / 2];
        System.out.println("The pivot value is: " + pivot);
        while (leftPos < rightPos) {
            while (arr[leftPos] < pivot) {
                leftPos++;
                System.out.println("Incrementing left pointer to " + arr[leftPos]);
            }
            while (arr[rightPos] > pivot) {
                rightPos--;
                System.out.println("Decrementing right pointer to " + arr[rightPos]);
            }
            if (leftPos < rightPos) {
                swap(arr, leftPos, rightPos);
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("--------------------");
        return leftPos;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        System.out.println("--------------------");
        System.out.println(Arrays.toString(arr));
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        System.out.println("Left array " + Arrays.toString(left));
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        System.out.println("Right array " + Arrays.toString(right));
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        System.out.println("--------------------");
        System.out.println("Start merging " + Arrays.toString(left) + " " + Arrays.toString(right));
        int[] merged = new int[left.length + right.length];
        int leftPos = 0, rightPos = 0, mergePos = 0;
        while (left.length > leftPos && right.length > rightPos) {
            if (left[leftPos] < right[rightPos]) {
                merged[mergePos++] = left[leftPos++];
            } else {
                merged[mergePos++] = right[rightPos++];
            }
        }
        System.arraycopy(left, leftPos, merged, mergePos, left.length - leftPos);
        System.arraycopy(right, rightPos, merged, mergePos, right.length - rightPos);
        System.out.println("Merged array " + Arrays.toString(merged));
        return merged;
    }

    public static int[] bubbleSort(int[] arr) {
        boolean swapping = true;
        while (swapping) {
            swapping = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    System.out.println(Arrays.toString(arr));
                    swap(arr, i, i + 1);
                    System.out.println("--------------------");
                    swapping = true;
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        System.out.printf("Swapping pair %d, %d%n", arr[index1], arr[index2]);
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
